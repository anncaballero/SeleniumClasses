package com.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class HW3 extends CommonMethods {

	/*
	 * Verify element is enabled
	 * Open chrome browser Go to “https://the-internet.herokuapp.com/”
	 *  Click on “Click on the “Dynamic Controls” link 
	 *  Click on enable button Enter “Hello”
	 * and verify text is entered successfully Close the browser
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/p[@id='message']")));
		String textToEnter="Hello";
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(textToEnter);
		String enteredText=driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		
		if(textToEnter.equals(enteredText)) {
			System.out.println("Verification pass");
		}else {
			System.out.println("Verification did not pass");
		}
		
		driver.quit();

	}

}
