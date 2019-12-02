package com.newtours.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.helper.SeleniumTestBase;
import com.newtours.pages.HomePage;

public class HomePageTest extends SeleniumTestBase{

	HomePage homepage;
	
	
	
	@Test
	public void verifyLogin() {
		
		homepage = new HomePage(driver);		
		homepage.login("mercury", "mercury");
	}

}
