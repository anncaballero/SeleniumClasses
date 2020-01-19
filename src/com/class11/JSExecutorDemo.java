package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class JSExecutorDemo extends CommonMethods {
	
	/*
	 * navigate to the HRMS
	 * enter uid and pwd
	 * click on login btn using JSExecutor
	 */

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("admin");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");

		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		
		//highlight the element in a desire color
		js.executeScript("arguments[0].style.backgroundColor='Red'", loginBtn);
		Thread.sleep(5000);
		
		//click on not clickable element
		js.executeScript("arguments[0].click();", loginBtn);
		
		//scroll through page
		js.executeScript("window.scrollBy(0,22050)");
		
		driver.quit();
		
	}

}
