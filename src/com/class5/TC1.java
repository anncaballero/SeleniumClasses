package com.class5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TC1 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {

		/*
		 * JavaScript alert text verification 
		 * Open chrome browser Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” 
		 * Click on “Alerts & Modals” links 
		 * Click on “Javascript Alerts” links 
		 * Click on button in “Java Script Alert Box” section Verify alert box with text “I am an alert box!” is present 
		 * Click on button in “Java Script Confirm Box” section Verify alert box
		 * with text “Press a button!” is present 
		 * Click on button in “Java Script Alert Box” section Enter text in the alert box Quit browser
		 */
		
		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		
		Alert alert=driver.switchTo().alert();
		String text1=alert.getText();
		
		if(text1.equals("I am an alert box!")) {
			System.out.println("The I am an alert box! text is present");
		}else {
			System.out.println("The I am an alert box! text is not present");
		}
		
		alert.accept();
		
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		
		String text2=alert.getText();
		
		if(text2.equals("Press a button!")) {
			System.out.println("The Press a button! text is present");
		}else {
			System.out.println("The Press a button! text is not present");
		}
		
		alert.accept();
		
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		
		alert.sendKeys("Ann Caballero");
		
		alert.accept();
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
