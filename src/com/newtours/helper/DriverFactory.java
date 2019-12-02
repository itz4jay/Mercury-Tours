package com.newtours.helper;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {
	
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);
	
	public static final Map<String,WebDriver> webDriverMap = new HashMap<String,WebDriver>();
	
	public static WebDriver getDriver(String browserType) {
		
		WebDriver driver = webDriverMap.get(browserType);
		
		if(driver == null) {
			
			synchronized (DriverFactory.class) {
				
				boolean remoteDriver = TestSetup.isRemoteTestRun();
				
				if(remoteDriver) {
					logger.info("Creating remote webdriver instance for driver type -> "+ browserType);
					try {
						driver = SeleniumRemoteWebDriver.createDriver(browserType);
						
					}catch(MalformedURLException e) {
						throw new RuntimeException("Error occured while instantiating remote web driver for "+browserType, e);
					}
				}else {
					logger.info("Creating local webdriver instance for driver type -> "+ browserType);
					driver = SeleniumLocalWebDriver.createDriver(browserType);
				}
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(AutomationTestConstant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(AutomationTestConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
			}
		}
		
		return driver;
	}

}
