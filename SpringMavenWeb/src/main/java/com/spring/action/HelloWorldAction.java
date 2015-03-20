package com.spring.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spring.actionForm.HelloWorldForm;

public class HelloWorldAction  extends Action {

	@Override
	 public ActionForward execute(ActionMapping mapping, ActionForm form,
		        HttpServletRequest request, HttpServletResponse response){
		
		HelloWorldForm hForm = (HelloWorldForm)form;
		hForm.setMessage("hello , this is struts application");
		return mapping.findForward("hello");
	}

}
