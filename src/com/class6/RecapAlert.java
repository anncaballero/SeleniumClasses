package com.class6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class RecapAlert extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

			setUp("chrome","http://166.62.36.207/syntaxpractice/index.html");
			driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']")).click();
			
			Alert alert=driver.switchTo().alert();
			String alertText=alert.getText();
			System.out.println(alertText);
			alert.accept();
		
			Thread.sleep(3000);
			driver.quit();

	}

}
