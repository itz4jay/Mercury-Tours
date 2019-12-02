package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	WebDriver driver;
	
	@FindBy(name = "userName")
	WebElement txtBoxUN;
	
	@FindBy(name = "password")
	WebElement txtBoxPwd;
	
	@FindBy(name = "login")
	WebElement btnLogin;
	
	public HomePage(WebDriver drv) {
		PageFactory.initElements(drv, this);
	}
	
	public void login(String uname, String pwd) {
		
		txtBoxUN.sendKeys(uname);
		txtBoxPwd.sendKeys(pwd);
		btnLogin.click();
		
	}

}
