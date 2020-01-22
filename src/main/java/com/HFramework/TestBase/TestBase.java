package com.HFramework.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.HFramework.ExcelReader.WorkbookReader;
import com.HFramework.PageObjects.LoginPageObjects;
import com.HFramework.managers.FileReaderManager;
import com.HFramework.utility.TestContext;
import com.google.common.io.Files;

public class TestBase {
	private static WebDriver driver;
	
	static int TestCaseRownumber;
	static int TestCaseresultRownumber;

	public TestBase(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public static String getScreenShot(WebDriver driver, String imageNames) throws IOException {
		// in case you don't want to supply screen shot name
		// if (imageNames.equals("")) {
		// imageNames = "blank";
		// }

		// Calendar cal = Calendar.getInstance();
		Date d = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("YYYY_MM_DD-hh-mm-ss");
		String time = formater.format(d.getTime());

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + imageNames + "-" + time + ".png";

		File destFile = new File(destination);

		Files.copy(source, destFile);

		return destination;
	}
	
	public static String gettime()
	{
		Date d = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		String time = "" + formater.format(d.getTime());
		return time;
	}

	public void WaiteForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,
				FileReaderManager.getInstance().getConfigReader().getWebdriverWait());

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	@DataProvider
	public static Object[][] Authontication(String testcasename) throws Exception {
		

		WorkbookReader.setExcelFile("TestCaseData", "TestCaseResults");

		TestCaseRownumber = WorkbookReader.getTestCaseRownumber(testcasename);

		TestCaseresultRownumber = WorkbookReader.getTestCaseresults(testcasename);

		Object[][] testdata = WorkbookReader.getcelldata(TestCaseRownumber);

		return testdata;

	}

	public boolean isAlertPresent() throws InterruptedException {

		boolean presentFlag = false;

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			presentFlag = true;
			// if present consume the alert
			alert.accept();
			// ( Now, click on ok or cancel button )

		} catch (NoAlertPresentException ex) {
			// Alert not present
			// ex.printStackTrace();
		}

		return presentFlag;
	}

}
