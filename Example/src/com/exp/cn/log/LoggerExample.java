package com.exp.cn.log;

import org.apache.log4j.Logger;

public class LoggerExample {
	static Logger log =Logger.getLogger(LoggerExample.class.getName());
	
	public static void main(String[] args) {
		log.info("info");
		log.warn("warn");
		log.debug("debug");
		log.error("error");
		log.fatal("fatal");
		
	}

}
