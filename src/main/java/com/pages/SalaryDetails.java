package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SalaryDetails {

	WebDriver driver;

	public SalaryDetails(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "borrowerIncome")
	@CacheLookup
	WebElement individualannualincome;
	@FindBy(how = How.NAME, using = "borrowerAdditionalIncome")
	@CacheLookup
	WebElement additionalincome;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='continuePersonalInfo']")
	@CacheLookup
	WebElement continuebtn;
	
	
	public void salaryInfo() {
		individualannualincome.sendKeys("130000");
		additionalincome.sendKeys("7500");
		continuebtn.sendKeys(Keys.SPACE);
	}

}
