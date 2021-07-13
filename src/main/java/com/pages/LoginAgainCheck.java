package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginAgainCheck {

	WebDriver driver;

	public LoginAgainCheck(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	WebElement username;
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement passwordfield;
	@FindBy(how = How.XPATH, using = "//button[text()='Sign in to your account']")
	@CacheLookup
	WebElement signin;

	
	public void checkLoginAndFieldValidations(String email, String password) {
		username.sendKeys(email);
		passwordfield.sendKeys(password);
		signin.sendKeys(Keys.SPACE);		
		
	}
}
