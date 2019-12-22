package com.class1;

import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {

	public static void main(String[] args) {

		/*
		 * Syntax Page URL Verification: Open chrome browser Navigate to
		 * “https://www.syntaxtechs.com/” Navigate to “https://www.google.com/” Navigate
		 * back to Syntax Technologies Page Refresh current page Verify url contains
		 * “Syntax”
		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.syntaxtechs.com");
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().refresh();
		
		if(driver.getCurrentUrl().contains("syntax")) {
			System.out.println("URLs match");
		}else {
			System.err.println("try again");
		}
		
		driver.close();
		

	}

}
