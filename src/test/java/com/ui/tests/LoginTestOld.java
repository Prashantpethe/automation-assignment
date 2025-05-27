package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestOld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver wd = new ChromeDriver();// browser session is created
		wd.get("https://www.automationpractice.pl/index.php");
		wd.manage().window().maximize();//chaining of methods
		
		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");
		//no such element  exception exception and invalid selector exception
		WebElement signInLinkWebElement=wd.findElement(signInLinkLocator); // find the element
		signInLinkWebElement.click();
		
		By emailTextBoxLocator = By.id("email");
		WebElement emailTextBoxWebElement = wd.findElement(emailTextBoxLocator);
		emailTextBoxWebElement.sendKeys("sogeh70447@harinv.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		WebElement passwordTextBoxWebElement = wd.findElement(passwordTextBoxLocator);
		passwordTextBoxWebElement.sendKeys("password");
		
		By submitLoginButtonLocator = By.id("SubmitLogin");
		WebElement submitLoginButtonWebElement = wd.findElement(submitLoginButtonLocator);
		submitLoginButtonWebElement.click();
		
		//bad practices in above script 
		//1 hard coding
		//2duplicate code
		//3.TestData is directly attached to script
		//4. Variable name is not correct e.g wd
		//5 Excepion handling is not there
		//6 Synchronization - we are not supposed to use wd.findelement we have to use explicit wait bcz findele is not sync
		//7 Assertion is missing
		//8 Abstraction is not taken care , need to create wrapper methods over selenium methods
		
		
	}

}
