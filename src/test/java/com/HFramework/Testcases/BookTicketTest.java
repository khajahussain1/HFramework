package com.HFramework.Testcases;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HFramework.ExcelReader.WorkbookReader;
import com.HFramework.PageObjects.BookTicketPageObjects;
import com.HFramework.utility.Extentsreports;
import com.HFramework.utility.Log;
import com.HFramework.utility.TestContext;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BookTicketTest {

	private TestContext testContext = null;
	BookTicketPageObjects bookTicket;
	private String testcasename;
	private int TestCaseRownumber;
	private int TestCaseresultRownumber;
	static ExtentReports extent;
	static ExtentTest test;
	SimpleDateFormat formater;
	static String time;

	@BeforeMethod
	public void beforetest(Method result) {
		testContext = new TestContext();
		bookTicket = testContext.getPageObjectManager().getbookTicket();
		testcasename = this.getClass().getSimpleName();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase(testcasename);
		Date d = new Date();
		formater = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		time = "" + formater.format(d.getTime());
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/target/Extents-Reports/Extentreport" + time + ".html");
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		

	}

	@Test(dataProvider = "Authontication")
	public void BookTicket(String phno, String password) throws Exception {
		try {

			bookTicket.select_from_dropdown();
			bookTicket.select_from_dropdown_value();
			bookTicket.select_to_dropdown_value();
			WorkbookReader.setresults("PASS", TestCaseresultRownumber);
		} catch (Exception e) {
			WorkbookReader.setresults("FAIL", TestCaseresultRownumber);

			// TestBase.getScreenShot(testContext.getWebDriverManager().getDriver(),
			// testcasename);
		}

	}

	@DataProvider
	public Object[][] Authontication() throws Exception {

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

			String screenshot_path = Extentsreports.captureScreenshot(result.getName());

			String image = test.addScreenCapture(screenshot_path);

			test.log(LogStatus.FAIL, "Title verification", image);

		}
		extent.endTest(test);
		extent.flush();
		// testContext.getWebDriverManager().quitDriver();
		Log.endTestCase(testcasename);

	}

}
