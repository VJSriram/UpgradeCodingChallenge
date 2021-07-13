package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountUser {

	WebDriver driver;

	public CreateAccountUser(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	static WebElement email;
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	static WebElement password;
	@FindBy(how = How.XPATH, using = "//*[@name='agreements']")
	@CacheLookup
	WebElement consentmsg;
	@FindBy(how = How.XPATH, using = "//*[@class='sc-efHYUO jZAvRP section']")
	@CacheLookup
	WebElement checkyourrate;

	public void checkfinalrates(String emailadress, String passwordtoenter) throws InterruptedException {
		
		email.sendKeys(emailadress); 
		password.sendKeys(passwordtoenter);
		Thread.sleep(2000);
		consentmsg.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		checkyourrate.sendKeys(Keys.SPACE);
		
	}

}
