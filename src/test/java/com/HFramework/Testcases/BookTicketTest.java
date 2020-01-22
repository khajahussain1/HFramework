package com.HFramework.Testcases;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HFramework.ExcelReader.WorkbookReader;
import com.HFramework.PageObjects.BookTicketPageObjects;
import com.HFramework.TestBase.TestBase;
import com.HFramework.utility.Extentsreports;
import com.HFramework.utility.Log;
import com.HFramework.utility.TestContext;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BookTicketTest {

	TestContext testContext;
	private BookTicketPageObjects bookTicket = null;
	private String testcasename;
	private int TestCaseRownumber;
	private int TestCaseresultRownumber;
	ExtentReports extent;
	ExtentTest test;
	TestBase testbase;

	@BeforeMethod
	public void beforetest(Method result) throws Exception {
		///testbase = new TestBase(testContext.getWebDriverManager().getDriver());
		//testbase.Authontication(testcasename);
		//TestBase.Authontication(testcasename);
		
		testContext = new TestContext();
		testcasename = this.getClass().getSimpleName();	
		
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/target/Extents-Reports/Extentreport" + TestBase.gettime() + ".html");
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		
		bookTicket = testContext.getPageObjectManager().getbookTicket();
		//DOMConfigurator.configure("log4j.xml");
		//Log.startTestCase(testcasename);

	}

	@Test(dataProvider = "Authontication")
	public void BookTicket() throws Exception {
		try {

			bookTicket.select_from_dropdown();
			bookTicket.select_from_dropdown_value();
			bookTicket.select_to_dropdown_value();
			WorkbookReader.setresults("PASS", TestCaseresultRownumber);
		} catch (Exception e) {
			WorkbookReader.setresults("FAIL", TestCaseresultRownumber);

			// TestBase.getScreenShot(testContext.getWebDriverManager().getDriver(),
			// testcasename);
			throw (e);
		}

	}

	

	@DataProvider
	public Object[][] Authontication() throws Exception {
		testcasename = this.getClass().getSimpleName();

		WorkbookReader.setExcelFile("TestCaseData", "TestCaseResults");

		TestCaseRownumber = WorkbookReader.getTestCaseRownumber(testcasename);

		TestCaseresultRownumber = WorkbookReader.getTestCaseresults(testcasename);

		Object[][] testdata = WorkbookReader.getcelldata(TestCaseRownumber);

		return testdata;

	}

	@AfterMethod
	public void aftertest(ITestResult result) {
		if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " test is pass");

		} else if (result.getStatus() == ITestResult.SKIP)

		{
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());

			String screenshot_path = Extentsreports.captureScreenshot(testContext.getWebDriverManager().getDriver(),
					result.getName());

			String image = test.addScreenCapture(screenshot_path);

			test.log(LogStatus.FAIL, "Title verification", image);

		}

		// testContext.getWebDriverManager().quitDriver();
		Log.endTestCase(testcasename);

	}

	@AfterClass
	public void afterclass() {
		extent.endTest(test);
		extent.flush();
	}

}
