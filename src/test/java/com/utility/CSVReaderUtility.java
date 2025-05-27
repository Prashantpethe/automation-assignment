package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + "//testData//"+fileName); // just a pointer,
																								// pointing to file
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList=null;
		User userData;
		try {
			// all declarations needs to be outside try block
			fileReader = new FileReader(csvFile); // gives filenotfound exception
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();// reading col names or row 1 , readNext reading immediate line, as we are not
									// storing it skips it
			// csvReader.readNext();// reading row 2, this also skips
			// csvReader.readNext();// row 3
			// data=csvReader.readNext();// row 4 is empty, we get output as null
			// no row or we have reached the end of the CSV file , readNext returns you null
			userList = new ArrayList<User>();
		
			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
//			for (User userData : userList) {
//				System.out.println(userData);
//			}
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();

	}

}
