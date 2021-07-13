package com.helper;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.pages.CreateAccountUser;
import com.pages.LoanDetails;
import com.pages.Login;
import com.pages.LoginAgainCheck;
import com.pages.SalaryDetails;
import com.pages.UserDetails;

public class TestCase extends Helper {

	public TestCase() {
	}

	@Test
	public void navigateAndCheckrate() throws InterruptedException {
		driver.get("https://www.credify.tech/funnel/nonDMFunnel");
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.checkTheRates();
		
		UserDetails userdet = PageFactory.initElements(driver, UserDetails.class);
		userdet.userInformation();
		
		SalaryDetails saldet = PageFactory.initElements(driver, SalaryDetails.class);
		saldet.salaryInfo();
		
		Random rand = new Random();
		int upperbound = 100;
		final String emailid = "Vijay"+rand.nextInt(upperbound)+"@update-challenge.com";
		final String passwrd = "Test1238765";
		
		CreateAccountUser createusr = PageFactory.initElements(driver, CreateAccountUser.class);
		createusr.checkfinalrates(emailid, passwrd);
				
		LoanDetails loandet = PageFactory.initElements(driver, LoanDetails.class);
		loandet.userInformation();
		
		driver.get("https://www.credify.tech/portal/login");
		
		LoginAgainCheck loginagain = PageFactory.initElements(driver, LoginAgainCheck.class);
		loginagain.checkLoginAndFieldValidations(emailid, passwrd);
		
		loandet.validateInformation();
	}	
}
