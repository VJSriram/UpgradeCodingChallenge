package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Login {

	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "desiredAmount")
	@CacheLookup
	WebElement loanamount;
	@FindBy(how = How.NAME, using = "loan-purpose")
	@CacheLookup
	WebElement loanpurpose;
	@FindBy(how = How.XPATH, using = "//*[text()='Check your rate']")
	@CacheLookup
	WebElement knowyourrate;

	public void checkTheRates() {
		loanamount.sendKeys("2000");
		Select se = new Select(loanpurpose);
		se.selectByIndex(1);
		knowyourrate.sendKeys(Keys.SPACE);
	}

}
