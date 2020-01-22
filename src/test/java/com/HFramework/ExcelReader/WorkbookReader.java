package com.HFramework.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.HFramework.utility.TestContext;
import com.google.common.io.Files;

public class WorkbookReader {

	private static XSSFWorkbook wb;
	private static XSSFSheet sh;
	private static XSSFSheet sh1;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	private static String path = System.getProperty("user.dir") + "/src/main/resources/TestData/TestData.xlsx";

	public static WebDriver driver = null;

	public static void setExcelFile(String TestData, String ResultData) throws Exception {

		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			wb = new XSSFWorkbook(ExcelFile);
			sh = wb.getSheet(TestData);
			sh1 = wb.getSheet(ResultData);

		} catch (FileNotFoundException e)

		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
	}

	public static int getTestCaseRownumber(String testcasename) {

		int i;

		try {

			int totalrows = sh.getLastRowNum();

			// int totalrows = sh.getPhysicalNumberOfRows();

			System.out.println("total no of rows for read data :->" + totalrows);

			for (i = 1; i < totalrows; i++) {

				String celldata = sh.getRow(i).getCell(0).getStringCellValue();

				if (celldata.equalsIgnoreCase(testcasename)) {
					

					break;
				}
			}

			return i;

		} catch (Exception e) {
			throw e;
		}
	}

	public static Object[][] getcelldata(int TestCaseRownumber) throws Exception

	{

		String[][] celldata = null;

		try {
			int totalRows = 1;

			int totalCols = sh.getRow(TestCaseRownumber).getLastCellNum() - 1;

			System.out.println("total columns for read data :- " + totalCols);

			celldata = new String[totalRows][totalCols];

			int ci = 0, cj = 0;

			for (int j = 1; j <= totalCols; j++, cj++)

			{

				celldata[ci][cj] = sh.getRow(TestCaseRownumber).getCell(j).getStringCellValue();

				System.out.print(celldata[ci][cj] + " : ");

			}

		} catch (Exception e) {

			throw (e);

		}
		return (celldata);

	}

	public static int getTestCaseresults(String testcasename) {

		int k;

		try {

			int totalrows = sh1.getLastRowNum();

			System.out.println("total no of rows for write data:->" + totalrows);

			for (k = 1; k < totalrows; k++) {

				String celldata = sh1.getRow(k).getCell(0).getStringCellValue();

				if (celldata.equalsIgnoreCase(testcasename)) {

					break;
				}
			}

			return k;

		} catch (Exception e) {
			throw e;
		}
	}

	// This method is to write in the Excel cell, Row num and Col num are the

	// parameters

	public static void setresults(String Result, int TestCaseRownumber) throws Exception {

		// int totalCol = sh1.getRow(TestCaseRownumber).getLastCellNum();
		try {

			Row = sh1.getRow(TestCaseRownumber);

			Cell = sh1.getRow(TestCaseRownumber).getCell(1, Row.RETURN_BLANK_AS_NULL);

			// sh1.getRow(TestCaseRownumber).getCell(1).setCellValue(Result);

			// Cell.setCellValue(Result);

			if (Cell == null) {
				Cell = Row.createCell(1);

				Cell.setCellValue(Result);
			} else {

				Cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fo = new FileOutputStream(path);

			wb.write(fo);

			fo.flush();

			fo.close();
		} catch (Exception e) {
			//throw (e);
		}
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
}
