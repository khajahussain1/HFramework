package com.HFramework.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HFramework.TestBase.TestBase;
import com.HFramework.utility.Log;

public class LoginPageObjects {

	WebDriver driver;
	Actions act;
	TestBase testbase;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		testbase = new TestBase(driver);
		PageFactory.initElements(driver, this);

	}

	/*@FindBy(xpath = "//a[@id='ctl00_HyperLinkLogin']")
	WebElement Login_Signup_button;

	@FindBy(xpath = "//*[text()='SpiceClub Members']")
	WebElement SpiceCash_SpiceClub_Member_button;*/

	@FindBy(linkText = "Member Login")
	private WebElement Member_Login;

	@FindBy(xpath = "/input[@id='ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID']")
	private WebElement mobile_number;

	@FindBy(xpath = "//input[@id='ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword']")
	private WebElement password_txtbox;

	@FindBy(xpath = "//input[@id='ControlGroupLoginView_MemberLoginView2LoginView_ButtonLogIn']")
	private WebElement login_button;

	
	public void Member_Login_button() {
		act = new Actions(driver);

		try {

			testbase.WaiteForElement(Member_Login);

			Log.info("Explicity wait applied on the driver for 60 seconds");

			act.moveToElement(Member_Login).build().perform();

			testbase.WaiteForElement(Member_Login);

			Member_Login.click();

			Log.info("Member_Login is found on the Home page");

		} catch (Exception e) {

			Log.error("Member_Login is not found on the Home page " + e);
			throw (e);
		}
	}

	public void mobile_number_txtbox(String ph_number) {
		testbase.WaiteForElement(mobile_number);

		Log.info("Explicity wait applied on the driver for 60 seconds");

		mobile_number.sendKeys(ph_number);

		Log.info("mobile_number is found on the Home page");

	}

	public void password_txtbox(String password) {
		testbase.WaiteForElement(password_txtbox);

		Log.info("Explicity wait applied on the driver for 60 seconds");

		password_txtbox.sendKeys(password);

		Log.info("password_txtbox is found on the Home page");

	}

	public void Login_buton() throws InterruptedException {
		testbase.WaiteForElement(login_button);

		Log.info("Explicity wait applied on the driver for 60 seconds");

		login_button.click();

		Log.info("password_txtbox is found on the Home page");
		Thread.sleep(2000);

		// testbase.isAlertPresent();

		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();

		} catch (Exception e) {
			//System.out.println(e);

		}
	}
}
