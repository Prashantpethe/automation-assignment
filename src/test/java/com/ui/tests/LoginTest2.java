package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver wd = new ChromeDriver();// browser session is created
		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebSite("https://www.automationpractice.pl/index.php");
		
		browserUtility.maximizeWindow();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");
		//no such element  exception exception and invalid selector exception
		browserUtility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "sogeh70447@harinv.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "password");
		
		By submitLoginButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginButtonLocator);
	}

}
