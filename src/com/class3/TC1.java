package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * TC 1: HRMS Application Login: Open chrome browser Go to
		 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login” Enter
		 * valid username and password VaughnEdward	VaughnEdward@$12!
		 * Click on login button Then verify Syntax Logo is
		 * displayed. 
		 */

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("VaughnEdward");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("VaughnEdward@$12!");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		
		WebElement syntaxLogo=driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));
		if (syntaxLogo.isDisplayed()) {
			System.out.println("The syntax logo is displayed");
		}else {
			System.err.println("The syntax logo is NOT displayed");
		}
		
		Thread.sleep(2000);
			
		driver.close();

	}

}
