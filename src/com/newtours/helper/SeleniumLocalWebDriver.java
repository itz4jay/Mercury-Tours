package com.newtours.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLocalWebDriver {
	
	public static WebDriver driver = null;
	
	public static WebDriver createDriver(String browserType) {
		
		String[] KeyPath = TestSetup.getDriverKeyPath(browserType);
		
		System.setProperty(KeyPath[0], KeyPath[1]);
		
		if(browserType.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
}
