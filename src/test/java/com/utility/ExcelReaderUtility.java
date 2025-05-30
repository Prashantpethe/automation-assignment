package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelFile(String fileName)  {
		
		File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		
		//XSSFWorkbook class needed to read xlsx file
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet =null;
		List<User> userList = null;
		Row row;
		Cell emailAddressCell,passwordCell;
		User user;
		Iterator<Row> rowIterator = null;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			xssfSheet=xssfWorkbook.getSheet("LoginTestData");
			userList = new ArrayList<User>();
			rowIterator=xssfSheet.iterator();
			rowIterator.next();//skip 1st row i.e col name
			while(rowIterator.hasNext()) {
				row=rowIterator.next();
				emailAddressCell=row.getCell(0);
				passwordCell=row.getCell(1);
				user= new User(emailAddressCell.toString(),passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();
			}	
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
