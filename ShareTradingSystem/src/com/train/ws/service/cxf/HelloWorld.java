package com.train.ws.service.cxf;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	public String sayHi(String name);
}
