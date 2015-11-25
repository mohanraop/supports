package com.filecompare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filecompare.service.FileDetailsService;
import com.filecompare.vo.FileDetailsVO;

@RestController
public class FileDetailsController {

	@Autowired
	FileDetailsService fileDetailsService ;
	
	//-------------------Retrieve All File Details--------------------------------------------------------
    
    @RequestMapping(value = "/fileDetails/", method = RequestMethod.GET)
    public ResponseEntity<List<FileDetailsVO>> listAllFileDetails() {
        List<FileDetailsVO> fileDetails = fileDetailsService.getAllFileDetails();
        if(fileDetails.isEmpty()){
            return new ResponseEntity<List<FileDetailsVO>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FileDetailsVO>>(fileDetails, HttpStatus.OK);
    }
    
    
    //------------------- submit FileDetails  --------------------------------------------------------
     
    @RequestMapping(value = "/submitFileDetails/", method = RequestMethod.PUT)
    public ResponseEntity<List<FileDetailsVO>> submitFileDetails( @RequestBody FileDetailsVO fileDetailsVO) {
    	fileDetailsService.processFileDetails(fileDetailsVO);
    	return new ResponseEntity<List<FileDetailsVO>>(HttpStatus.NO_CONTENT);
    }
    
}
