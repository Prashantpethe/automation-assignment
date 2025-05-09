package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;

public final class HomePage extends BrowserUtility{
	
	

	private final static By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browserName) {
		super(browserName);// call parent class constructor from child class constructor
		goToWebSite("https://www.automationpractice.pl/index.php");
	}
//	public void goToLoginPage() { //page functions cannot have void return type
//		
//	}
	
public LoginPage goToLoginPage() { //page functions cannot have void return type
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
