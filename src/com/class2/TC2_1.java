package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_1 {

	public static void main(String[] args) {

		/*
		 * Using Xpath ONLY TC 1: Facebook login: Open chrome browser Go to
		 * “https://www.facebook.com/” Enter valid username and valid password and click
		 * login User successfully logged in
		 */
		
		System.getProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("annscaballero@gmail.com");
		

	}

}
