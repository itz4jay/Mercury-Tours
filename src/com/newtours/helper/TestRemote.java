package com.newtours.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestRemote {
	
	public static void main(String[] args) {
		
		String hubURL = "http://172.19.42.177:4444/wd/hub";
		ChromeOptions caps = new ChromeOptions(); 
		WebDriver driver = null;
		
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                UnexpectedAlertBehaviour.IGNORE);
		
		try {
			driver = new RemoteWebDriver(new URL(hubURL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.get("http://newtours.demoaut.com/");
		
	}
	

}
