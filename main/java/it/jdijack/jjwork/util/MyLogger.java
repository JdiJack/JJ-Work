package it.jdijack.jjwork.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
	
	private static Logger logger;
	
	public static Logger getLogger(){
		if(logger==null)
			logger = LogManager.getFormatterLogger("jjwork"); 
		return logger;
	}
	
	

}
