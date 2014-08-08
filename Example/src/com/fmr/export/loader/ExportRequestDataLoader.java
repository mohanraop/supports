package com.fmr.export.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fmr.export.bean.ExportWorkItemObj;
import com.fmr.export.dao.ExportWorkItemRequestDao;

public class ExportRequestDataLoader {
	
	private static Logger log = Logger.getLogger(ExportRequestDataLoader.class);
	static String lPropertyFileName ="";
	static String inputFolder,completeFolder="",rejectedFOlder;
	//private static ServiceLocator serviceLocator = ServiceLocator.getInstance();
	static Connection dbConnection = null;
	static String dbUser,dbPassword,connURL="";
	static final String dataSepartor="|";
	static long clientID;
	static long currFileLineCnt;
	static String IN_PROGRESS_STATUS="IN_PROGRESS";
	static String COMPLETED_STATUS="COMPLETED";
	
	public static ExportWorkItemObj splitDataRecord(String pString)
    {
		ExportWorkItemObj workItemObj =  null;
        int lastPos = 0;
        int pos_recType=1;
        int pos_clientCode=12;
        int pos_reqId=10;
        int pos_fimdDocId=18;
        int pos_repositoryCD=20;
        int pos_clipID=64;
        int pos_xtractId=8;
        int pos_xtractValue=25;
        if(pString.length()>=158){
        	workItemObj = new  ExportWorkItemObj();
        	lastPos=pos_recType;
        	//workItemObj.setClient_Id(Integer.parseInt(pString.substring(lastPos, lastPos+pos_clientCode).trim()));
        	workItemObj.setClient_Id(123);
        	lastPos=lastPos+pos_clientCode;
        	workItemObj.setRequest_Id(Integer.parseInt(pString.substring(lastPos, lastPos+pos_reqId).trim()));
        	lastPos=lastPos+pos_reqId;
        	workItemObj.setFims_id(Integer.parseInt(pString.substring(lastPos, lastPos+pos_fimdDocId).trim()));
        	lastPos=lastPos+pos_fimdDocId;
        	workItemObj.setRepository_cd(pString.substring(lastPos, lastPos+pos_repositoryCD).trim());
        	lastPos=lastPos+pos_repositoryCD;
        	workItemObj.setClip_id(pString.substring(lastPos, lastPos+pos_clipID).trim());
        	lastPos=lastPos+pos_clipID+pos_xtractId;
        	workItemObj.setClip_id(pString.substring(lastPos, lastPos+pos_xtractValue).trim());
        	workItemObj.setStatus(IN_PROGRESS_STATUS);
        }
        return  workItemObj;
    }
	public static String[] splitTrailerRecord(String pString){
		String[] record=null;
		int i=0;
		int lastPos = 0;
        int pos_recType=1;
        int pos_clinetCD=12;
        int pos_reqID=10;
        int pos_numOfRec=10;
        if(pString.trim().length()>=33){
        	record =  new String[3];
        	lastPos=pos_recType;
        	record[i++]=pString.substring(lastPos, lastPos+pos_clinetCD).trim();
        	lastPos=lastPos+pos_clinetCD;
        	record[i++]=pString.substring(lastPos, lastPos+pos_reqID).trim();
        	lastPos=lastPos+pos_reqID;
        	record[i++]=pString.substring(lastPos, lastPos+pos_numOfRec).trim();
        }
        return record;
		
	}
        
	
	private static void loadWorkItems(BufferedReader inpStream, String fileName) throws Exception
	{
		
		int recCount=0;
		int warnCount=0;
		String lRecord="";
		ExportWorkItemRequestDao exportWorkItemRequestDao = ExportWorkItemRequestDao.getInstance();
		//read the file
		List<ExportWorkItemObj> workItemObjs = new ArrayList<ExportWorkItemObj>();
		String[] trailerRecord=null;
		while (( lRecord = inpStream.readLine()) != null)
		{
			
			if (lRecord==null || lRecord.trim().equals("")) continue;
			//if (recCount==0) continue;
			if (lRecord.startsWith("D")){ 
				ExportWorkItemObj workItemObj= splitDataRecord(lRecord);
				if(workItemObj!=null){
					workItemObjs.add(workItemObj);
				}
			}else if (lRecord.startsWith("T")){
				trailerRecord=splitTrailerRecord(lRecord);
				break;
			}
		}
		if(trailerRecord!=null && trailerRecord.length==3){
			recCount = Integer.parseInt(trailerRecord[2]);
			if(recCount>0 &&recCount==workItemObjs.size()){
				//log.debug(recCount + ":" + inputData[0] + ":" + inputData[1] + ":" + inputData[2]+ ":" + inputData[3]+ ":" + inputData[4]+ ":" + inputData[5]);
				try
				{
					exportWorkItemRequestDao.insertExportWorkItem(dbConnection, workItemObjs);
				}
				catch (SQLException se)
				{
					moveFile(fileName, rejectedFOlder);
					throw new Exception("while inserting date reords is failed of file="+fileName);
				}
				try
				{
					exportWorkItemRequestDao.insertExportRequestItem(dbConnection, trailerRecord[0],trailerRecord[1],trailerRecord[2],IN_PROGRESS_STATUS);
				}
				catch (SQLException se)
				{
					moveFile(fileName, rejectedFOlder);
					throw new Exception("while inserting date reords is failed of file="+fileName);
				}
			}else{
				moveFile(fileName, rejectedFOlder);
				throw new Exception("reord count is not matching trailer reord count in the requested file="+fileName);
			}
		}else{
			moveFile(fileName, rejectedFOlder);
			throw new Exception("trailer reord is not found in the requested file="+fileName);
		}
		log.info(recCount + " of " + currFileLineCnt + " loaded...");
		//commit any remaining records
		dbConnection.commit();
		log.info("---------------------");
		log.info("Total count   : "+ recCount);
		log.info("Success count : "+ workItemObjs.size());
		log.info("Failure count : "+ warnCount);
		log.info("---------------------");
	}
	
	private static void setConnection()
	{
		try {
			lPropertyFileName = System.getProperty("config.file");
			//serviceLocator.setPropFileName(lPropertyFileName);

			// create the connection to the database
			//connURL = serviceLocator.getProperty("DB_SRVR");
			//dbUser = serviceLocator.getProperty("DB_USER_NAME");
			//dbPassword = serviceLocator.getProperty("DB_PSWD");
			
			connURL = "jdbc:oracle:thin:@localhost:1521:xe";
			dbUser = "amarpatlolla";
			dbPassword = "amar01";
			ExportWorkItemRequestDao cnvDAO = new ExportWorkItemRequestDao(dbUser, dbPassword, connURL);
			dbConnection = cnvDAO.getConnection();
			if (dbConnection == null) {
				log.error("ERROR: database connection is null: ");
				
				System.exit(-1);
			}
			dbConnection.setAutoCommit(false);
			log.info("Got Connection");
			inputFolder="C:\\Users\\Amar\\workspace_eclipse\\Example\\all";//serviceLocator.getProperty("INPUT_LOCATION");
			completeFolder = "C:\\Users\\Amar\\workspace_eclipse\\Example\\all";//serviceLocator.getProperty("COMPLETE_LOCATION");
			rejectedFOlder= "C:\\Users\\Amar\\workspace_eclipse\\Example\\all";//serviceLocator.getProperty("REJECTED_LOCATION");
		} catch (Exception ex) {
			log.error("Error while loading data: " + ex.getMessage());
		}
	}
	
	private static long getNumLines(String pFileName) throws Exception
	{
		LineNumberReader lineCounter = new LineNumberReader(
				new InputStreamReader(new FileInputStream(inputFolder+System.getProperty("file.separator")+pFileName)));
		String nextLine = null;

		try {
			while ((nextLine = lineCounter.readLine()) != null) //{
				if (nextLine == null)
					break;
				//System.out.println(nextLine);
			//}
			//System.out.println("Total number of line in this file " + lineCounter.getLineNumber());
			
		} catch (Exception done) {
			done.printStackTrace();
		}
		lineCounter.close();
		return new Long(lineCounter.getLineNumber()).longValue();
	}
	private static void loadData2Table(String fileName)
	{
		BufferedReader inpStream=null;
		try
		{
			log.info("input location: " + inputFolder);
			log.info(inputFolder+System.getProperty("file.separator")+fileName);
			currFileLineCnt=getNumLines(fileName);
			if(currFileLineCnt>2000){
				log.error("request file contain more than 2000 records");
				moveFile(fileName,rejectedFOlder);
				throw new Exception("request file:"+fileName+" contain more than 2000 records");
			}
			inpStream = new BufferedReader(
								new FileReader(inputFolder+System.getProperty("file.separator")+fileName));
			//create Oracle connection
			log.info("Loading Data from: " + fileName);
			
			//insert into WORKITEMS
			loadWorkItems(inpStream, fileName);
		
			log.info("Loading Completed");
			//if (inpStream != null) inpStream.close();
		}
		catch (FileNotFoundException fex)
		{
			log.error("File not found to load");
		}
		catch (Exception ex)
		{
			log.error("Error while loading data: "+ ex.getMessage());
		}
		finally
		{
			try
			{
				if (inpStream != null) inpStream.close();
			}
			catch (IOException ioe) {log.error("Error while closing the input stream");}
		}
	}
	
	private static int checkFileExists(String pFileName) throws Exception
	{
		int docIndex=0;
		/*
		 * scan the output folder
		 */
		/*DirectoryScanner scanner = new DirectoryScanner();
		scanner.setIncludes(new String[]{"**\\"+pFileName+"*"});
		//scanner.setIncludes(new String[]{"**\\**\\"+pFileName+"*.txt"});//{"**\\**\\"+pDocumentID+"*.pdf"});
		log.info("completeFolder: "+ completeFolder);
		scanner.setBasedir(completeFolder);
		scanner.setCaseSensitive(false);
		scanner.scan();*/
		String[] files1 = null;//scanner.getIncludedFiles();
		log.info("included files length: " + files1.length);
		log.info("about to check report File: " + pFileName);
		
		String[] inDirs = null;//scanner.getIncludedDirectories();
		log.info("included inDirs length: " + inDirs.length);
		for (int i=0;i<inDirs.length;i++)
			log.info("included dirs: " + inDirs[i]);
		for(int i = 0; i < files1.length; i++ )
			docIndex++;
		return docIndex;
	}
	
	private static void moveFile(String fileName,String destFolder) throws Exception
	{
		/*
		 * move the input file to output folder
		 */
		if(destFolder.equals(completeFolder)){
			log.info("moving file " + fileName + " to completeFolder: " + completeFolder);
		}else if (destFolder.equals(rejectedFOlder)){
			log.info("moving file " + fileName + " to completeFolder: " + completeFolder);
		}
		boolean moved = false;
		File file = new File(inputFolder+ 
	    		System.getProperty("file.separator") + fileName); 
		try
		{	
			/*
			 * first rename to <filename>_complete.<ext>
			 * then move to complete folder
			 */
			File destFile = new File(inputFolder, fileName);
			int fileVersionNum = checkFileExists(fileName);
			if (fileVersionNum>0)
				fileName = fileName+"_" +fileVersionNum;
			File destFile1 = null;
			if(destFolder.equals(completeFolder)){
				log.info("Filename: "+ fileName+".complete");
				destFile1 = new File(destFolder, fileName+".complete");
			}else if (destFolder.equals(rejectedFOlder)){
				log.info("Filename: "+ fileName+".rejected");
				destFile1 = new File(destFolder, fileName+".rejected");
			}
			
			if(destFile1.exists())
				if(!destFile1.delete())
					throw new Exception("Unable to overwrite existing file " + destFile.getName() + " in " + completeFolder +" directory.");

			moved=destFile.renameTo(destFile1);
			if (!moved)
			{
				if(destFolder.equals(completeFolder)){
					log.error("Error while moving to complete folder: " + destFile.getName());
				}else if (destFolder.equals(rejectedFOlder)){
					log.error("Error while moving to rejected folder: " + destFile.getName());
				}
				
				log.error("destFile1: " + destFile1.getName());
				throw new Exception("Unable to overwrite existing file " + file.getName() + " in " + destFolder +" directory.");
			}
		}
		catch(Exception e)
		{
			log.error("Error while moving file to complete folder: " + e);
			throw new Exception(e.getMessage());
		}        
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			//scan for file
			
			/*
			 *   
			 *  
			 *  args[0]  =>  look for request file with name args[0]
			 *  
			 * 	
			 *  Load args[0] named file 
			 *  	log error if duplicate file exists and move the file as duplicate ???
			 *  move the the file to Complete folder
			 *  
			 
			if (args ==null || args.length<1 )
			{
				System.out.println("USAGE: ExportRequestDataLoader <RequestFileName>");
				System.exit(-1);
			}
			
			if ((args[0].trim().equals("")) || (args[0]==null))
			{
				System.out.println("USAGE: ExportRequestDataLoader <RequestFileName>");
				System.exit(-1);
			}		
			
			*/
			setConnection();
			
			String fileNmFmt ="info.txt";

			log.info("fileNameFormat: " + fileNmFmt);
			/*DirectoryScanner scanner = new DirectoryScanner();
			scanner.setIncludes(new String[]{fileNmFmt});
			scanner.setBasedir(inputFolder);
			scanner.setCaseSensitive(true);
			scanner.scan();
			String[] files1 = scanner.getIncludedFiles();*/
			String[] files1 =new String[]{"info.txt"};;
			log.info("about to check input folder: "+ inputFolder +" for File: " );
			/*String[] inDirs = scanner.getIncludedDirectories();
			for (int i=0;i<inDirs.length;i++)
				log.info("included dirs: " + inDirs[i]);*/
			
			
			//String tableNm="";
			if(files1!=null && files1.length>0)
			for (int i=0;i<files1.length;i++)
			{
				if (files1[i].matches(fileNmFmt))
				{
					log.info("included files: " + files1[i]);
					/*if (isHistorical.equals("Y"))
						batchDt = "0101"+batchDt;*/
					
					log.info("files1["+i+"]: "+ files1[i]);
					/*
					 * Verify for the current day, a batch record is created
					 * if not created,
					 * 	call insertbatch with the file date and client name
					 * if for the current date there is alredy record use the batch_id 
					 */
					
					loadData2Table(files1[i]);
					//move the file from incoming to complete folder
					moveFile(files1[i],completeFolder);				
				}
				else
					log.info("****excluded files: " + files1[i]);
			}
		}
		catch (Exception se)
		{
			se.printStackTrace();
			log.error("Error while loading data: " + se.getMessage());
		}
		finally
		{
			try
			{
				if (dbConnection!=null && !dbConnection.isClosed())
					dbConnection.close();
				log.info("Connection closed");
			}
			catch (SQLException se)
			{
				log.error("Unable to close connection");
			}
		}
	}

}
