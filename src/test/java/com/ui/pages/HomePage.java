package com.ui.pages;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

//import com.utility.JSONUtility;
import static com.utility.JSONUtility.*;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private final static By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(Browser browserName) {
		super(browserName);// call parent class constructor from child class constructor
		// goToWebSite("https://www.automationpractice.pl/index.php");
		// goToWebSite(PropertiesUtil.readProperty(Env.QA, "URL"));
//		goToWebSite(readProperty(QA, "URL")); // reading from properties file
		goToWebSite(readJson(QA).getUrl()); // read from json file
	}
//	public void goToLoginPage() { //page functions cannot have void return type
//		
//	}

	public LoginPage goToLoginPage() { // page functions cannot have void return type
		logger.info("Trying to perform click to go to sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
