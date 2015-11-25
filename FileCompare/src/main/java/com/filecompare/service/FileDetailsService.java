package com.filecompare.service;

import java.util.List;

import com.filecompare.vo.FileDetailsVO;

public interface FileDetailsService {

	/**
	 * @return
	 */
	public List<FileDetailsVO> getAllFileDetails();
	
	
	/**
	 * @param fileDetails
	 */
	public void updateFileResponceByDesc(FileDetailsVO fileDetailsVO);


	/**
	 * @param detailsVO
	 */
	void processFileDetails(FileDetailsVO detailsVO);
}
