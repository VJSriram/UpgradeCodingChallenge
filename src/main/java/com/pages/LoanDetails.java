package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoanDetails {

	WebDriver driver;

	public LoanDetails(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h3[text()='Monthly Payment']//following-sibling::div")
	@CacheLookup
	static WebElement monthlypayment;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='defaultLoanTerm']//div")
	@CacheLookup
	static WebElement Term;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='defaultLoanInterestRate']//div")
	@CacheLookup
	static WebElement interestrate;
	@FindBy(how = How.XPATH, using = "//div[@data-auto='defaultAPR']")
	@CacheLookup
	static WebElement apr;
	@FindBy(how = How.XPATH, using = "//span[@data-auto='userLoanAmount']")
	@CacheLookup
	static WebElement loanamount;
	@FindBy(how = How.XPATH, using = "//*[@class='header-nav__toggle']")
	@CacheLookup
	static WebElement navigationmenu;
	@FindBy(how = How.XPATH, using = "//*[@class='header-nav-menu__link' and text()='Sign Out']")
	@CacheLookup
	static WebElement logout;
	@FindBy(how = How.XPATH, using = "//*[@class='header-nav-menu']//li[2]//a")
	@CacheLookup
	static WebElement logout2;
	
	@FindBy(how = How.XPATH, using = "//*[@data-auto='offer-card-content-submit']//li[1]//div")
	@CacheLookup
	static WebElement finalmonthlypayment;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='offer-card-content-submit']//li[2]//div")
	@CacheLookup
	static WebElement finalterm;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='offer-card-content-submit']//li[3]//div")
	@CacheLookup
	static WebElement finalinterestrate;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='offer-card-content-submit']//li[4]//div")
	@CacheLookup
	static WebElement finalapr;
	@FindBy(how = How.XPATH, using = "//*[@data-auto='userLoanAmount']")
	@CacheLookup
	static WebElement finalloanamt;
	
	
	
	
	static String monthypayment;
	static String trm;
	static String interestrates;
	static String aprr;
	static String loanamt;
	
	public void userInformation() {
		
		monthypayment = monthlypayment.getText();
		trm = Term.getText();
		interestrates = interestrate.getText();
		aprr = apr.getText();
		loanamt = loanamount.getText();
		navigationmenu.sendKeys(Keys.SPACE);
		logout.sendKeys(Keys.SPACE);
		logout2.sendKeys(Keys.SPACE);
			
	}
	
	public boolean validateInformation() {
				
		return monthypayment.equalsIgnoreCase(finalmonthlypayment.getText()) && 
		   trm.equalsIgnoreCase(finalterm.getText()) &&
		   interestrates.equalsIgnoreCase(finalinterestrate.getText()) &&
		   aprr.equalsIgnoreCase(finalapr.getText()) &&
		   loanamt.equalsIgnoreCase(finalloanamt.getText());
		
	}
}
