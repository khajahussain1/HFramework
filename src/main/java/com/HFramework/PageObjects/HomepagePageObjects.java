package com.HFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HFramework.TestBase.TestBase;
import com.HFramework.utility.Log;

public class HomepagePageObjects {
	WebDriver driver;
	Actions act;

	TestBase testBase;

	public HomepagePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testBase = new TestBase(driver);

	}

	@FindBy(xpath = "//a[@id='ctl00_HyperLinkLogin']")
	private WebElement Login_Signup_button;

	@FindBy(xpath = "//*[text()='SpiceClub Members']")
	private WebElement SpiceCash_SpiceClub_Member_button;

	@FindBy(xpath = "//a[@href='https://book.spicejet.com/Register.aspx']")
	private WebElement Signup_button;

	@FindBy(xpath = "//a[@href='https://book.spicejet.com/Register.aspx']")
	private WebElement clickon_Signup_button;

	public void mousemoveon_Login_Signup_button() {
		act = new Actions(driver);

		try {

			testBase.WaiteForElement(Login_Signup_button);
			
			Log.info("Explicity wait applied on the driver for 60 seconds");

			act.moveToElement(Login_Signup_button).build().perform();
			
			Log.info("Login_Signup_button is found on the Home page");

		} catch (Exception e) {

			Log.error("Login_Signup_button is not found on the Home page " + e);
			throw (e);
		}
	}

	public void mousemoveon_SpiceCash_SpiceClub_Member_button() {
		try {

			testBase.WaiteForElement(SpiceCash_SpiceClub_Member_button);
			
			Log.info("Explicity wait applied on the driver for 60 seconds");

			act.moveToElement(SpiceCash_SpiceClub_Member_button).build().perform();
			
			Log.info("SpiceCash_SpiceClub_Member_button is found on the Home page");

		} catch (Exception e) {
			
			Log.error("SpiceCash_SpiceClub_Member_button is not found on the Home page" + e);

		}
	}

	public void mousemoveon_Signup_button() throws InterruptedException {
		try {
			
		
		testBase.WaiteForElement(Signup_button);
		
		Log.info("Explicity wait applied on the driver for 60 seconds");
		
		act.moveToElement(Signup_button).build().perform();
		
		Log.info("Signup_button is found");
		
	}catch(Exception e) {
		
		Log.info("Signup_button is not found "+e);
		throw(e);
	}
		
	}

	public void clickon_Signup_button() throws InterruptedException {
		try {
			
		testBase.WaiteForElement(clickon_Signup_button);
		Log.info("Explicity wait applied on the driver for 60 seconds");
		
		clickon_Signup_button.click();
		Log.info("Signup button is found");
		
		}
		catch(Exception e)
		{
			Log.info("Signup button is not found "+e);
			throw(e);
			
		}
	}

}
