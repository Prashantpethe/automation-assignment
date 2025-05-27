package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility { // parent class marked with Abstract keyword
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();// bczof this update code to
																				// driver.get()

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

//	private WebDriver driver; //instance var goes into heap, null is def value for non primitive datatype
	// constructor initialize instance var
	// convert above driver into thread local for parallel screenshot

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) // notice here it is string abd below itis enumname
	{
		logger.info("Browser launched" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else {
			logger.error("invalid Browser name");
			// System.err.print("invalid browser name");
		}

	}

	public BrowserUtility(Browser browserName) {
		logger.info("Browser launched" + browserName);
		if (browserName == Browser.CHROME) { // notice how enums are compared

//			driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
//			driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		} else
			logger.error("invalid Browser name");
		// no need of else block with enum
	}

	public void goToWebSite(String url) {
		logger.info("Visting the website" + url);
//		driver.get(url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("maximizingthe browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info(" element found and now performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info(" element found and now entering text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text" + element.getText());
		return element.getText();
	}

	public void closeBrowser() {
		driver.get().quit();
		logger.info("closes browsr session");
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenShot = (TakesScreenshot) driver.get();
		File screenshotData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
