package com.newtours.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestSetup {
	
	private static Properties testMetaData = new Properties();
	
	static {
		try {
			testMetaData.load(new FileInputStream("data/TestSetupConfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean isRemoteTestRun() {
		
		String runEnv = testMetaData.getProperty("test.run.env");
		
		if(runEnv.equalsIgnoreCase("remote")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static String getHubURL() {
		
		return testMetaData.getProperty("hub.URL");
	}
	
	
	public static String[] getDriverKeyPath(String browserType) {
		
		String[] KeyPath = new String[2];
		
		KeyPath[0] = testMetaData.getProperty(browserType+"Key");
		KeyPath[1] = testMetaData.getProperty(browserType+"Path");
		
		return KeyPath;
	}
	
	
	

	
}
