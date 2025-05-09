package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Browser;

public abstract class BrowserUtility { // parent class marked with Abstract keyword
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver; //instance var goes into heap, null is def value for non primitive datatype
	//constructor initialize instance var
	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver=driver;
	}
	
	public BrowserUtility(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else
			System.err.print("invalid browser name");
	}
	
	public BrowserUtility(Browser browserName)
	{
		if(browserName==Browser.CHROME){ // notice how enums are compared
			driver = new ChromeDriver();
		}
		// no need of else block with enum
	}
	
	
	public void goToWebSite(String url)
	{
		driver.get(url);
	}
	
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		WebElement element = driver.findElement(locator);
		element.click();
	}
	
	public void enterText(By locator , String textToEnter) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator)
	{
		WebElement element = driver.findElement(locator);
		return element.getText();
	}

}
