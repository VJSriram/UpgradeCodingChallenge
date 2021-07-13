package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PageFactories {

	public static WebDriver driver;

	public PageFactories() {

	}

public static WebDriver getDriver(){
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
    driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	return driver;
	}
}

