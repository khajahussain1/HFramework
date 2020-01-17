package com.HFramework.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HFramework.TestBase.TestBase;
import com.HFramework.utility.Log;

public class RegistrationPageObjects {
	WebDriver driver;
	Select se;
	TestBase testBase;

	public RegistrationPageObjects(WebDriver driver) {
		System.out.println("started RegistrationPageObjects page");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testBase = new TestBase(driver);

	}

	@FindBy(xpath = "//select[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle']")
	WebElement select_title;

	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName']")
	WebElement firstname_txtbox;

	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName']")
	WebElement laststname_txtbox;

	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINTLMOBILENUMBER']")
	WebElement mobilenumber_txtbox;

	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword']")
	WebElement password_txtbox;

	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm']")
	WebElement confirm_password_txtbox;
	
	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB']")
	WebElement dob_txtbox;

	@FindBy(xpath = "//span[text()='1996']")
	WebElement year_button;

	@FindBy(xpath = "//span[text()='Jun']")
	WebElement month_button;

	@FindBy(xpath = "//span[text()='17']")
	WebElement day_button;

	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail']")
	WebElement email_address_txtbox;

	@FindBy(xpath = "//input[@id='chkSpiceClubTnC']")
	WebElement agree_checkbox;

	@FindBy(xpath = "//input[@id='CONTROLGROUPREGISTERVIEW_ButtonSubmit']")
	WebElement submit_button;

	public void select_Title_dropdown() {
		testBase.WaiteForElement(select_title);
		se = new Select(select_title);
		se.selectByVisibleText("MR");
	}

	public void setfirstname(String firstname) {
		try {

			testBase.WaiteForElement(firstname_txtbox);
			Log.info("Explicity wait applied on the driver for 60 seconds");

			firstname_txtbox.sendKeys(firstname);
			Log.info("FirstName text box is found on Registration page");
			Log.info(firstname + " is entered as First Name on the Registration page");
		} catch (Exception e) {
			Log.error("First name text box is not found on the Registration page " + e);
			throw (e);
		}
	}

	public void setlastname(String lastname) {
		try {
			testBase.WaiteForElement(laststname_txtbox);

			laststname_txtbox.sendKeys(lastname);
			Log.info("Last Name text box is found on Registration page");
			Log.info(lastname + " is entered as Last Name on the Registration page");

		} catch (Exception e) {
			Log.error("Last Name text box is not found on the Registration page " + e);
			throw (e);

		}
	}

	public void setmobilenumber(String mobilenumber) {
		try {

			testBase.WaiteForElement(mobilenumber_txtbox);
			mobilenumber_txtbox.sendKeys(mobilenumber);
			try {
			Alert alt = driver.switchTo().alert();
			alt.accept();
			}catch(Exception e1) {
				
			}
			Log.info("Mobile number text box is found on the Registration page");
			Log.info(mobilenumber + " is entered as Email on the Registration page");

		} catch (Exception e) {
			Log.error("Mobile Number text box is not found on the Registration page " + e);
			throw (e);

		}

		
	}

	public void setpassword(String password) {
		try {

			testBase.WaiteForElement(password_txtbox);
			password_txtbox.sendKeys(password);
			Log.info("Password text box is found on the Registratio page");
			Log.info(password + " is entered as password on the Registration page");

		} catch (Exception e) {
			Log.error("Password page is not found on the Registration page " + e);
			throw (e);

		}
	}

	public void setconfirmpassword(String confirmpassword) {
		try {

			testBase.WaiteForElement(confirm_password_txtbox);
			confirm_password_txtbox.sendKeys(confirmpassword);
			Log.info("Confirmpassword text box is found on the Registration page");
			Log.info(confirmpassword + " is entered as confirm password on the Registration page");

		} catch (Exception e) {
			Log.error("Confirm password text box is not found on the Registration page " + e);
			throw (e);

		}
	}

	public void click_on_dob_txtbox() {
		try {
			Log.info("Day drop down is found on Registration page");
			testBase.WaiteForElement(dob_txtbox);
			dob_txtbox.click();

			Log.info("dob_txtbox is clicked on the Registration page");

		} catch (Exception e) {
			Log.error("Day drop down is not selected on registration page " + e);
			throw (e);

		}

	}

	public void click_on_year_button() {
		testBase.WaiteForElement(year_button);
		year_button.click();

	}

	public void click_on_month_button() {
		month_button.click();
	}

	public void click_on_day_button() {
		testBase.WaiteForElement(day_button);
		day_button.click();

	}

	public void setemailaddress(String emailaddress) {
		testBase.WaiteForElement(email_address_txtbox);
		email_address_txtbox.sendKeys(emailaddress);
	}

	public void agreecheckbox() {
		agree_checkbox.click();
	}

	public void clickonsubmitbutton() {
		testBase.WaiteForElement(submit_button);
		submit_button.click();
		// driver.close();
		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();

		} catch (Exception e) {

		}
	}

}
