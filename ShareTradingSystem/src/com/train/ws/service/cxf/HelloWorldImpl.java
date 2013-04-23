/**
 * 
 */
package com.train.ws.service.cxf;

import javax.jws.WebService;

/**
 * @author madhu
 *
 */

@WebService(targetNamespace = "http://www.example.org/contract/HelloWorld", 
            serviceName="HelloWorld", 
            endpointInterface="com.train.ws.service.cxf.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	/* (non-Javadoc)
	 * @see com.train.ws.service.cxf.HelloWorld#sayHi(java.lang.String)
	 */
	public String sayHi(String name) {
		return "Hello "+name;
	}

}
