package com.HFramework.utility;

import com.HFramework.managers.PageObjectManager;
import com.HFramework.managers.WebDriverManager;

public class TestContext {

	
	private WebDriverManager webDriverManager = null;
	private PageObjectManager pageObjectManager = null;
	//public ScenarioContext scenarioContext;

	public TestContext() {		
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		//scenarioContext = new ScenarioContext();
	}

	public WebDriverManager getWebDriverManager() {

		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	/*public ScenarioContext getScenarioContext() {
		
		return scenarioContext;
	}*/

}