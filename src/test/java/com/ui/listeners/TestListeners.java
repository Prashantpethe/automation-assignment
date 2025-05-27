package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListeners implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	// non primitive data type will have def value as null
	ExtentSparkReporter extentSparkReporter; // funtionality to generate HTML file (look, styling)
	ExtentReports extentReports; // heavy lifting
	ExtentTest extentTest; // to store info about test

	public void onTestStart(ITestResult result) { // result var willhave allinfo
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups())); // Arrays.toStringwill print all values in one
																		// line statement
//		extentTest = extentReports.createTest(result.getMethod().getMethodName());
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
//		extentTest.log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
//		extentTest.log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testclass = result.getInstance();

		BrowserUtility browserUtility = ((TestBase)testclass).getInstance();
		logger.info("capturing screenshot for the failed tests");
		String screenShotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching screenshot to the HTML file");
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenShotPath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
//		extentTest.log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
	}

	public void onStart(ITestContext context) { // test suite is started
		logger.info("Test Suite Started");
//		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//report.html");
//		extentReports = new ExtentReports();
//		extentReports.attachReporter(extentSparkReporter);
		ExtentReportUtility.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Ended");
//		extentReports.flush();
		ExtentReportUtility.flushReport();
	}

}
