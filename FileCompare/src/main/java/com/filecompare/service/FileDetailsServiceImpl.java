package com.filecompare.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filecompare.mapper.FileDetailsMapper;
import com.filecompare.model.FileDetails;
import com.filecompare.vo.FileDetailsVO;

@Service("fileDetailsService")
@Transactional
public class FileDetailsServiceImpl implements FileDetailsService{

	@Autowired
	FileDetailsMapper fileDetailsMapper;
	
	public enum ResponseStatus{
		SUCCESS("success"),FAIL("failure");
		String status;
		ResponseStatus(String st){
			status = st;
		}
		
	}
	/**
	 * @return
	 */
	@Override
	public List<FileDetailsVO> getAllFileDetails(){
		List<FileDetails> fileDetails = fileDetailsMapper.getAllFileDetails();
		List<FileDetailsVO> fileDetailsVOs = new ArrayList<>();
		for(FileDetails details : fileDetails){
			FileDetailsVO detailsVO = new FileDetailsVO();
			detailsVO.setFileDesc(details.getFileDesc());
			detailsVO.setFileResp(details.getFileResp());
			fileDetailsVOs.add(detailsVO);
		}
		return fileDetailsVOs;
	}
	
	
	/**
	 * @param fileDetails
	 */
	@Override
	public void updateFileResponceByDesc(FileDetailsVO fileDetailsVO){
		FileDetails fileDetails = new FileDetails();
		fileDetails.setFileResp(fileDetailsVO.getFileResp());
		fileDetails.setFileDesc(fileDetailsVO.getFileDesc());
		fileDetailsMapper.updateFileResponceByDesc(fileDetails);
	}
	
	
	@Override
	public void processFileDetails(FileDetailsVO detailsVO){
		List<FileDetails> fileDetails = fileDetailsMapper.getAllFileDetailsByDesc(detailsVO.getFileDesc());
		if(fileDetails!=null && !fileDetails.isEmpty()){
			FileDetails details = fileDetails.get(0);
			if(details.getFileInfo()!=null && details.getFileInfo().length>0){
				try {
					 dropFile(details.getFileInfo(), detailsVO.getDropLoc1(),details.getFileDesc());
					 dropFile(details.getFileInfo(), detailsVO.getDropLoc2(),details.getFileDesc());
					 boolean isSuccess = compareFiles(detailsVO.getPickLoc1(), detailsVO.getPickLoc2());
					 if(isSuccess){
						 details.setFileResp(ResponseStatus.SUCCESS.status); 
					 }else{
						 details.setFileResp(ResponseStatus.FAIL.status);
					 }
						 fileDetailsMapper.updateFileResponceByDesc(details);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void dropFile(byte[] data, String filePath,String fileDesc) throws IOException{
		 //convert array of bytes into file
	    FileOutputStream fileOuputStream =  new FileOutputStream(filePath+"\\"+fileDesc); 
	    fileOuputStream.write(data);
	    fileOuputStream.close();
	}
	
	private boolean compareFiles(String filePath1,String filePath2) throws IOException{
		boolean compare1and2 = FileUtils.contentEquals( new File(filePath1), new File(filePath2));
		return compare1and2;
	}
}
