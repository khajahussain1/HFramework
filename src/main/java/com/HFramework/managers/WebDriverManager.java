package com.HFramework.managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.HFramework.enums.DriverType;
import com.HFramework.enums.Environment;

public class WebDriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static Environment environment;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environment = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	
	/*public WebDriver getDriver() {

		if (driver == null) {

			driver = createDriver();
		}
		return driver;
	}*/
	
	/*private WebDriver createDriver() {

		if (environment.name().equals("LOCAL")) {

			driver = createLocalDriver();

		} else if (environment.name().equals("REMOTE")) {

			driver = createRemoteDriver();
		}
		return driver;

	}*/

	public WebDriver getDriver() {

		if (environment.name().equals("LOCAL")) {

			driver = createLocalDriver();

		} else if (environment.name().equals("REMOTE")) {

			driver = createRemoteDriver();
		}
		
		
		return driver;

	}

	private WebDriver createRemoteDriver() {

		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {

		if (System.getProperty("os.name").contains("Window")) {
			
			if (driverType.name().equals("FIREFOX")) {
				
				System.setProperty(GECKO_DRIVER_PROPERTY, System.getProperty("user.dir")
						+ FileReaderManager.getInstance().getConfigReader().getGeckoPath());

				driver = new FirefoxDriver();
				
			} else if (driverType.name().equals("CHROME")) {
				
				System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")
						+ FileReaderManager.getInstance().getConfigReader().getChromePath());

				driver = new ChromeDriver();
				
			} else if (driverType.name().equals("INTERNETEXPLORER")) {
				
				System.setProperty(IE_DRIVER_PROPERTY,
						System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getIEPath());

				driver = new InternetExplorerDriver();

			}

			if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())

				driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(
					FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
			
			driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

		}

		else if (System.getProperty("os.name").contains("Mac os")) {

			if (driverType.name().equals("FIREFOX")) {
				
				System.setProperty(GECKO_DRIVER_PROPERTY, System.getProperty("user.dir")
						+ FileReaderManager.getInstance().getConfigReader().getGeckoPath());

				driver = new FirefoxDriver();
				
			} else if (driverType.name().equals("CHROME")) {
				
				System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")
						+ FileReaderManager.getInstance().getConfigReader().getChromePath());

				driver = new ChromeDriver();
				
			} else if (driverType.name().equals("INTERNETEXPLORER")) {
				
				System.setProperty(IE_DRIVER_PROPERTY,
						System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getIEPath());

				driver = new InternetExplorerDriver();
			}

			if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())

				driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(
					FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);

			driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		}

		return driver;

	}

	public void quitDriver() {
		//driver.close();
		driver.quit();

	}

}