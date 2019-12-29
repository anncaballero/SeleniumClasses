package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * TC 1: Radio Buttons Practice Open chrome browser Go to
		 * “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” Click on “Input
		 * Forms” links Click on “Radio Buttons Demo” links Click on any radio button in
		 * “Radio Button Demo” section. Verify correct checkbox is clicked 
		 * Click on any
		 * radio button in “Group Radio Buttons Demo” section. Verify correct checkbox
		 * is clicked Quit browser
		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']")).click();
		boolean isSelected=driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']")).isSelected();
		System.out.println(isSelected);
		driver.findElement(By.xpath("//input[@name='ageGroup' and @value='5 - 15']")).click();
		boolean isSelected1=driver.findElement(By.xpath("//input[@name='ageGroup' and @value='5 - 15']")).isSelected();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
