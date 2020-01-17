package com.HFramework.stepdefination;

import com.HFramework.PageObjects.HomepagePageObjects;
import com.HFramework.utility.TestContext;



public class HomepageSteps {

	TestContext testContext;
	HomepagePageObjects homepage;

	public HomepageSteps(TestContext context) {
		System.out.println("Started home page stepdefination ");
		testContext = context;
		homepage = testContext.getPageObjectManager().getHomepage();
	}

	public void launch_the_spicejet_application() throws Throwable {
		System.out.println("user is on home page");
	}

	public void move_to_mouse_on_Login_SignUp_button() throws Throwable {

		homepage.mousemoveon_Login_Signup_button();
	}

	public void move_to_the_mouse_SpiceCash_SpiceClub_Member_button() throws Throwable {
		homepage.mousemoveon_SpiceCash_SpiceClub_Member_button();
	}

	public void move_to_the_mouse_Signup_button() throws Throwable {
		homepage.mousemoveon_Signup_button();

	}

	public void click_on_Signup_button() throws Throwable {
		homepage.clickon_Signup_button();
	}

	public void user_land_on_registration_page() throws Throwable {

		System.out.println("user land on registration page successfully");
	}

}
