package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * TC 2: Mercury Tours Registration: Open chrome browser Go to
		 * “http://newtours.demoaut.com/” Click on Register Link Fill out all required
		 * info Click Submit User successfully registered (Create 2 scripts using
		 * different locators)
		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("REGISTER")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("Ann");
		driver.findElement(By.name("lastName")).sendKeys("Caballero");
		driver.findElement(By.name("phone")).sendKeys("571-251-2619");
		driver.findElement(By.id("userName")).sendKeys("annscaballero@gmail.com");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("address1")).sendKeys("6545 Hello Dr.");
		driver.findElement(By.name("city")).sendKeys("Arlington");
		driver.findElement(By.name("state")).sendKeys("Virginia");
		driver.findElement(By.id("email")).sendKeys("arosegoldn");
		driver.findElement(By.name("password")).sendKeys("lalalala15");
		driver.findElement(By.name("confirmPassword")).sendKeys("lalalala15");
		
		driver.close();

	}

}
