package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class TC1 extends CommonMethods {

	/*
	 * Verify element is present
	 * Open chrome browser Go to “https://the-internet.herokuapp.com/” 
	 * Click on “Click on the “Dynamic Loading” link 
	 * Click on “Example 1...” and click on “Start” 
	 * Verify element with text “Hello World!” is displayed 
	 * Close the browser
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='start']/button")));
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		
		boolean isDisplayed=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']"))).isDisplayed();
		
		System.out.println("“Hello World!” is displayed= "+isDisplayed);
		
		driver.quit();
	}

}
