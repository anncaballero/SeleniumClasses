package com.class5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AlertDemo2 extends CommonMethods {
	
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		Thread.sleep(2000);
		
		//find the element Alerts and Modals and clicking on it
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		
		//finding the Javascript Alerts and clicking on it
		driver.findElement(By.linkText("Javascript Alerts")).click();
		
		//finding the button and click on it
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Thread.sleep(2000);
		
		//handle the alert
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		
		//to dismiss or cancel the alert, handing any negative actions
		alert.dismiss();
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
