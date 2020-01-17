package com.HFramework.stepdefination;

import com.HFramework.PageObjects.BookTicketPageObjects;
import com.HFramework.utility.TestContext;

public class BookTicketSteps {

	TestContext testContext;
	BookTicketPageObjects bookTicket;	

	public BookTicketSteps(TestContext testContext) {
		this.testContext = testContext;
		bookTicket = testContext.getPageObjectManager().getbookTicket();

	}
	
	public void tapondropdown()  {
		
		bookTicket.select_from_dropdown();
	}

	
	public void selectfromdropdownvalue()  {
		
		bookTicket.select_from_dropdown_value();
	}

	
	public void selecttodropdownvalue() {
		
		bookTicket.select_to_dropdown_value();
	}
	

}
