package com.train.ws.service.cxf;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {
	protected Server() throws Exception {
		System.out.println("Starting Server");
		// creating the context sets the server into motion.
		new ClassPathXmlApplicationContext(new String[] { "/Bean.xml" });
	}

	public static void main(String args[]) throws Exception {
		new Server();
		System.out.println("Server ready...");

		Thread.sleep(5 * 60 * 1000);
		System.out.println("Server exiting");
		System.exit(0);
	}
}
