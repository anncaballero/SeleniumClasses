package com.class1;

import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");
		
		final String expectedTittle="Google";
		String actualTittle=driver.getTitle();
		
		if(expectedTittle.equals(actualTittle)) {
			System.out.println("The actual and expected tittle matched");
		}else {
			System.err.println("The actual and expected tittle did not match");
		}
		
		System.out.println("*********************");
		
		String actualUrl=driver.getCurrentUrl();
		
		System.out.println(actualUrl);
		String expectedUrl="https://www.google.com/?gws_rd=ssl";
		
		if(actualUrl.equals(expectedUrl)) {
			System.out.println("Both URL matched");
		}else {
			System.err.println("Actual and expected URLs did not match");
		}
		
		driver.close();

	}

}
