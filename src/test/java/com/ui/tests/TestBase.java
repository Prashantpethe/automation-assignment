package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase { // Parent of all Test classes

	protected HomePage homePage;// instance variable
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "load the homepage of the website")
	public void setup() {
		homePage = new HomePage(CHROME);
		logger.info("load the homepage of the website");
	}
	
	public BrowserUtility getInstance() { // notice how return type is parent class reference
		return homePage;
	}

}
