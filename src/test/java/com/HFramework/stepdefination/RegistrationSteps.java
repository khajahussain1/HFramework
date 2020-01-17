package com.HFramework.stepdefination;

import com.HFramework.PageObjects.RegistrationPageObjects;
import com.HFramework.utility.TestContext;



public class RegistrationSteps {

	TestContext managerReder;
	RegistrationPageObjects registration;

	public RegistrationSteps(TestContext reader) {
		
		System.out.println("started registration page stepdefination");
		managerReder = reader;
		registration = managerReder.getPageObjectManager().getRegistration();
	}
	
	public void select_title() throws Throwable {
		registration.select_Title_dropdown();
	}

	public void enter_firstname_as(String firstname) throws Throwable {

		registration.setfirstname(firstname);
	}

	public void enter_lastname_as(String lastname) throws Throwable {

		registration.setlastname(lastname);
	}

	public void enter_mobile_number_as(String mobilenumber) throws Throwable {

		registration.setmobilenumber(mobilenumber);
	}

	public void enter_password_as(String password) throws Throwable {
		registration.setpassword(password);
	}

	public void enter_confirm_password_as(String confirmpassword) throws Throwable {
		registration.setconfirmpassword(confirmpassword);
	}

	public void select_date_of_birth() throws Throwable {
		registration.click_on_dob_txtbox();
		registration.click_on_year_button();
		registration.click_on_month_button();
		registration.click_on_day_button();

	}

	public void email_address_as(String emailaddress) throws Throwable {
		registration.setemailaddress(emailaddress);
	}

	public void check_on_checkbox() throws Throwable {
		registration.agreecheckbox();
	}

	public void click_on_submit_button() throws Throwable {
		registration.clickonsubmitbutton();

	}

}
