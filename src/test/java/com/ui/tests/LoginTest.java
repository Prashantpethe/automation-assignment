package com.ui.tests;

import static com.constants.Browser.*; //note this line 3:35:00 framework part 1, static imports

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//control shift O remove unused imports
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListeners.class})
public class LoginTest extends TestBase {

//	HomePage homePage;// instance variable
//	Logger logger = LoggerUtility.getLogger(this.getClass());

//	@BeforeMethod(description = "load the homepage of the website")
//	public void setup() {
//		homePage = new HomePage(CHROME);
//		logger.info("load the homepage of the website");
//	}

	@Test(description = "Verifies if the valid user is able to login intothe application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void login(User user) {
//		/*
//		 * Rules to write good script 1. Test script needs to be small 2.You cannot have
//		 * conditional statement, loops, try catch in your test methods. Test script
//		 * should follow test steps not any logic 3. Reduce use of local variables
//		 * 4.Atleast one assertion
//		 * 
//		 */
//
//		// HomePage homePage = new HomePage(CHROME); //this is not test , this is
//		// pre-requistite so move it out of this
//		// String userName=homePage.goToLoginPage().doLoginWith("sogeh70447@harinv.com",
//		// "password").getUserName();
//		// Assert.assertEquals(userName, "Prashant Pethe");
//
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdddress(), user.getPassword()).getUserName(),
				"Prashant Pethe");
	}

//	@Test(description = "Verifies if the valid user is able to login intothe application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVdataProvider")
//	public void loginCSVTest(User user) {
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdddress(), user.getPassword()).getUserName(),
//				"Prashant Pethe");
//	}
//
//	@Test(description = "Verifies if the valid user is able to login intothe application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExcelTest(User user) {
//		//logger.info("Execution started");
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdddress(), user.getPassword()).getUserName(),
//				"Prashant Pethe1");
//		//logger.info("Execution ended");
//	}

}
