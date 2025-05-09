package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver wd = new ChromeDriver();// browser session is created
		HomePage homePage = new HomePage(wd);
		LoginPage loginPage= homePage.goToLoginPage();
		loginPage.doLoginWith("sogeh70447@harinv.com", "password");
	}

}
