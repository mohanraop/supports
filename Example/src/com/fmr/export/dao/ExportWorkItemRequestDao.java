package com.fmr.export.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import oracle.jdbc.internal.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.DelegatingConnection;
import org.apache.log4j.Logger;

import com.fmr.export.bean.ExportWorkItemObj;

public class ExportWorkItemRequestDao {
	private static Logger log = Logger.getLogger(ExportWorkItemRequestDao.class);
	
	private String connURL;
    private String dbUser;
    private String dbPassword;
    //private static ServiceLocator serviceLocator = ServiceLocator.getInstance();
    private static ExportWorkItemRequestDao daoInstance = null;    
    /**
     * Initialization
     */
    public ExportWorkItemRequestDao(String userId, String userPwd, String url)
    { 
		dbUser = userId;
		dbPassword = userPwd;
		connURL	= url;
		daoInstance=this;
    }
    
    public ExportWorkItemRequestDao()
    {
    	
    }
    
    public static synchronized ExportWorkItemRequestDao getInstance()
    {
    	log.debug("init DAO instance...");
        if(daoInstance == null)
        	daoInstance = new ExportWorkItemRequestDao();
        return daoInstance;
    }
    /**
     * Creates a connection to database
     */
    public Connection getConnection() throws SQLException
    {
        Connection dbConnection = null;
    	try
		{
    		if (dbConnection != null)
    			return dbConnection;
    		
    		log.info("Getting Oracle connection");
		    //load the Oracle JDBC driver
			DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
		    //create the connection to the database
			dbConnection = DriverManager.getConnection (connURL, dbUser, dbPassword);
			log.info("Got Oracle connection");
        }
		catch (SQLException e)
		{
			log.debug("Unable to create Connection to DB: " + e.getMessage());
		}
        return dbConnection;
    }	
	
	public void insertExportWorkItem(Connection pConnection,
			List<ExportWorkItemObj> exportWorkItemObjs) throws Exception {
		CallableStatement cStmt = null;
		try {
			pConnection.setAutoCommit(false);
			ArrayDescriptor oracleVarchar2Collection =  ArrayDescriptor.createDescriptor("VARCHAR2_T",pConnection);
			ArrayDescriptor oracleNumberCollection =ArrayDescriptor.createDescriptor("NUMBER_T",pConnection);
			int size= exportWorkItemObjs.size();
			double[] client_Id=new double[size];
			double[] request_Id=new double[size];
			String[] workItem_Id=new String[size];
			double[] fims_id=new double[size];
			String[] clip_id=new String[size];
			String[] repository_cd=new String[size];
			String[] status=new String[size];
			int i=0;
			  for(ExportWorkItemObj itemObj:exportWorkItemObjs){
				  client_Id[i]=itemObj.getClient_Id(); 
				  request_Id[i]=itemObj.getRequest_Id();
				  workItem_Id[i]=itemObj.getWorkItem_Id();
				  fims_id[i]=itemObj.getFims_id();
				  clip_id[i]=itemObj.getClip_id();
				  repository_cd[i]=itemObj.getRepository_cd();
				  status[i]=itemObj.getStatus();
				  i++;
			  }
			
			cStmt = pConnection.prepareCall("{call PKG_Export_requestDetails.insertExportWorkItem(?,?,?,?,?,?,?)}");
			
			// Cast the Java arrays into Oracle arrays
	        ARRAY ora_client_Id = new ARRAY (oracleNumberCollection,   pConnection, client_Id);
	        ARRAY ora_request_Id    = new ARRAY (oracleNumberCollection, pConnection, request_Id);
	        ARRAY ora_workItem_Id   = new ARRAY (oracleVarchar2Collection, pConnection, workItem_Id);
	        ARRAY ora_fims_id    = new ARRAY (oracleNumberCollection, pConnection, fims_id);
	        ARRAY ora_clip_id   = new ARRAY (oracleVarchar2Collection, pConnection, clip_id);
	        ARRAY ora_repository_cd   = new ARRAY (oracleVarchar2Collection, pConnection, repository_cd);
	        ARRAY ora_status   = new ARRAY (oracleVarchar2Collection, pConnection, status);

	        // Bind the input arrays.
	        cStmt.setObject(1, ora_client_Id);
	        cStmt.setObject(2, ora_request_Id);
	        cStmt.setObject(3, ora_workItem_Id);
	        cStmt.setObject(4, ora_fims_id);
	        cStmt.setObject(5, ora_clip_id);
	        cStmt.setObject(6, ora_repository_cd);
	        cStmt.setObject(7, ora_status);
			cStmt.execute(); 
			pConnection.commit();
			/*ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor( "EXPORT_WORKITEMS_TYPE", pConnection );
			ARRAY array_to_pass = new ARRAY( descriptor, pConnection, (Object[]) exportWorkItemObjs.toArray());
			cStmt = pConnection.prepareCall("{call PKG_Export_requestDetails.insertExportWorkItem(?)}");
			cStmt.setArray( 1, array_to_pass ); */ 

		} catch (Exception se) {
			se.printStackTrace();
			log.error(se.getMessage());
			throw se;
		} finally {
			if (cStmt != null)
				cStmt.close();
		}
			
	}
	
	public void insertExportRequestItem(Connection pConnection,
			String clientId,String reqId, String recordCount,String status) throws Exception {
		CallableStatement cStmt = null;
		try {
			cStmt = pConnection.prepareCall("{call PKG_Export_requestDetails.insertExportRequest(?,?,?,?,?,?,?)}");
			cStmt.setInt(1, Integer.parseInt(clientId) ); 
			cStmt.setInt(2, Integer.parseInt(reqId) );
			cStmt.setInt(3, Integer.parseInt(recordCount) );
			cStmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()) );
			cStmt.setDate(5,  new Date(Calendar.getInstance().getTimeInMillis()) );
			cStmt.setDate(6,  new Date(Calendar.getInstance().getTimeInMillis()) );
			cStmt.setString(7, status);
			cStmt.execute(); 
		} catch (Exception se) {
			log.error(se.getMessage());
			throw se;
		} finally {
			if (cStmt != null)
				cStmt.close();
		}
	}
}