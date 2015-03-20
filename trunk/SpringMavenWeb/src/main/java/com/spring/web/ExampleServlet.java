package com.spring.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExampleServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String message ="hello";
		
		System.out.println(message);
		
	   PrintWriter pw = response.getWriter();
	   pw.write(message);
		
	}
}
