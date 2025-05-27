package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	// Example of singleton design pattern

	private static Logger logger;

	private LoggerUtility() { // cannot create object outside loggerutility class

	}

	public static Logger getLogger(Class<?> clazz) { // object will be created with help of this method
		Logger logger = null;
		if (logger == null)
			logger = LogManager.getLogger(clazz);
		return logger;
	}
}
