package com.filecompare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
	        return "UserManagement";
	    }
	  
	  
	  @RequestMapping(value="/fm", method=RequestMethod.GET)
	    public String getFileDetailsPage() {
	        return "FileManagement";
	    }

	  
	  
}