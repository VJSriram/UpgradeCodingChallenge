package com.pages;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserDetails {

	WebDriver driver;

	public UserDetails(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "borrowerFirstName")
	@CacheLookup
	WebElement firstname;
	@FindBy(how = How.NAME, using = "borrowerLastName")
	@CacheLookup
	WebElement lastname;
	@FindBy(how = How.NAME, using = "borrowerStreet")
	@CacheLookup
	WebElement address;
	@FindBy(how = How.XPATH, using = "//*[@class='geosuggest__item']")
	@CacheLookup
	WebElement addresssuggestion;
	@FindBy(how = How.NAME, using = "borrowerDateOfBirth")
	@CacheLookup
	WebElement dob;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='continuePersonalInfo']")
	@CacheLookup
	WebElement continuebtn;
	
	public void userInformation() {
		Random rand = new Random();
		int upperbound = 20;
		firstname.sendKeys("QA"+rand.nextInt(upperbound));
		lastname.sendKeys("user"+rand.nextInt(upperbound));
		address.sendKeys("3111 South Valley View Boulevard");
		Actions actions = new Actions(driver);
		actions.moveToElement(addresssuggestion);
		addresssuggestion.click();
		dob.sendKeys("01/01/1990");
		continuebtn.sendKeys(Keys.SPACE);
	}

}
