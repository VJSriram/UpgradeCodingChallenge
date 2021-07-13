package com.helper;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.utilities.PageFactories;

public class Helper {

	public static WebDriver driver;
	PageFactories obj1;

	public Helper() {
	}

	@Before
	public void beforeMethodClass() {
		Helper.driver = PageFactories.getDriver();

	}

	@After
	public void close() {
		driver.quit();
	}
}
