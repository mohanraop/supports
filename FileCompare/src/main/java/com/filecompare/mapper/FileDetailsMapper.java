package com.filecompare.mapper;

import java.util.List;

import com.filecompare.model.FileDetails;

public interface FileDetailsMapper {

	/**
	 * @return
	 */
	public List<FileDetails> getAllFileDetails();
	
	
	/**
	 * @param fileDetails
	 */
	public void updateFileResponceByDesc(FileDetails fileDetails);
	
	
	/**
	 * @param fileDesc
	 * @return
	 */
	public List<FileDetails> getAllFileDetailsByDesc(String fileDesc);
}
