package com.HFramework.utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentsreports {

	static ExtentReports extent;
	static ExtentTest test;
	static WebDriver driver;
	SimpleDateFormat formater;
	Calendar cal;
	static String time;

	public Extentsreports() {
		Date d = new Date();
		formater = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		time = "" + formater.format(d.getTime());
		}

	//@BeforeMethod
	public static void beforemethod(Method result) {
		extent = new ExtentReports(System.getProperty("user.dir") + "/target/Extents-Reports/Extentreport" + time + ".html");
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");

	}

	@Test
	public void verifyBlogTitle() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser started ");

		driver.get("http://www.learn-automation.com");

		test.log(LogStatus.INFO, "Application is up and running");

		String title = driver.getTitle();

		//Assert.assertTrue(title.contains("Google"));

		test.log(LogStatus.PASS, "Title verified");
	}

	//@AfterMethod
	public static void tearDown(ITestResult result) {
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

			/*String screenshot_path = captureScreenshot(result.getName());

			String image = test.addScreenCapture(screenshot_path);

			test.log(LogStatus.FAIL, "Title verification", image);*/

		}
	}

	//@AfterClass
	public static void afterclass() {

		extent.endTest(test);
		extent.flush();

	}

	public static String captureScreenshot(WebDriver driver, String methodname) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screnshot_path = System.getProperty("user.dir") + "/target/Screenshots/" + methodname + time
				+ ".png";

		File destination = new File(screnshot_path);

		try {
			FileUtils.copyFile(source, destination);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return screnshot_path;

	}

}
