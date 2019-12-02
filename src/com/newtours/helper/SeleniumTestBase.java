package com.newtours.helper;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class SeleniumTestBase {
	

	private static final Logger logger = LogManager.getLogger(SeleniumTestBase.class);
	protected WebDriver driver = null ;
	
	@BeforeClass
	@Parameters(value = "browser-type")
	public final void initializationBeforeClass(String driverType) {
		
		driver = DriverFactory.getDriver(driverType);
		logger.info("WebDriver initialization complete for :" + driverType);
		
		driver.get("http://newtours.demoaut.com/");
		
	}

	
	
	@AfterClass
	public final void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		logger.info("WebDriver tear down is complete");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
}
