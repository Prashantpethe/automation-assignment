package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase { // Parent of all Test classes

	protected HomePage homePage;// instance variable
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" }) // these are parameters name
	@BeforeMethod(description = "load the homepage of the website")
	public void setup(
			@Optional("chrome")String browser,  // if not running from testng.xml then use chrome as default value
			@Optional("false")boolean isLambdaTest, 
			@Optional("true")boolean isHeadless, 
			ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			// Running the test on local machine
//		homePage = new HomePage(CHROME,true);
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
			logger.info("load the homepage of the website");
		}
	}

	public BrowserUtility getInstance() { // notice how return type is parent class reference
		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			homePage.quit();
		}
	}

}
