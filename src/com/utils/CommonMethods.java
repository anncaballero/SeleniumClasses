package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	
	public static WebDriver driver;
	
	//java doc or java documentation, will appear as a method description
	
	/**
	 * Use this method to open WebPage.
	 * @param browser the desired browser
	 * @param url the desired URL
	 * @return
	 */
	
public static void setUp(String browser, String url){
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver.exe");
			driver=new ChromeDriver();
			driver.get(url);
		
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(url);
		}
		
	}
	

// public static WebDriver setUp(String browser){
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver");
//			driver=new ChromeDriver();
//		
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//			driver=new FirefoxDriver();
//		}
//		
//		return driver;
//	}

}


