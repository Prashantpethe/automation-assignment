package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	// properties file will have static methods
	// public static void main(String[] args) throws IOException {
	public static String readProperty(Env env, String propertyName) {
		// File is a calss from java.io pkg
		// File class object is responsible to tell java where is particular file
		// System.out.println(System.getProperty("user.dir"));
		// //C:\Users\Soberr\Desktop\SDET with Jatin\automation-assignment
//		File propFile = new File(System.getProperty("user.dir") + "\\config\\QA.properties");
		File propFile = new File(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
		// Above is just a pointer, not reading file
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);// compile time error bcz properties can read only .properties file but
			// fileReader can have txt file,json file
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;
//		String value=properties.getProperty("URL");
		// System.out.println(value); //http://wwww.automationpractice.pl
	}

}
