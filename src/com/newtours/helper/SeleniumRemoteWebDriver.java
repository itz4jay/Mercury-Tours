package com.newtours.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SeleniumRemoteWebDriver {
	
	private static final Logger logger = LogManager.getLogger(SeleniumRemoteWebDriver.class);

	public static WebDriver createDriver(String browserType) throws MalformedURLException{
		 
		WebDriver driver = null;
		
		Capabilities cap = getDesieredCap(browserType);
		
		String hubURL = TestSetup.getHubURL();
		
		if(hubURL == null || "".equals(hubURL.trim())){
			throw new RuntimeException("Hub URL is null or empty");
		}else {
			driver = new RemoteWebDriver(new URL(hubURL), cap);
		}
		
		return driver;
	}
	
	
	
	private static DesiredCapabilities getDesieredCap(String browserName) {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
        switch (browserName) {
		case "Chrome":
			capabilities = DesiredCapabilities.chrome();
			break;
		case "Firefox":
			capabilities = DesiredCapabilities.firefox();
			break;
		
		default:
			throw new RuntimeException("Invalid BrowserType passed");
		}
		return capabilities;
		
	}
	
}
