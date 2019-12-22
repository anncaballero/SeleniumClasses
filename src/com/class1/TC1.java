package com.class1;

import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) {

		/*
		 * Amazon Page Title Verification: Open chrome browser Go to
		 * “https://www.amazon.com/” Verify Title “Amazon.com: Online Shopping for
		 * Electronics, Apparel, Computers, Books, DVDs & more” is displayed
		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		
		String tittle=driver.getTitle();
		String expectedTittle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		System.out.println(tittle);
		
		if(tittle.equals(expectedTittle)) {
			System.out.println("correct tittle");
		}else {
			System.err.println("try again");
		}
		driver.close();	
		
	}

}
