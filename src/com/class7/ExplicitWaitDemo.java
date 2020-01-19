package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ExplicitWaitDemo extends CommonMethods{
	
	/*
	 * Navigate to the page
	 * click on others
	 * select dynamic data loading
	 * click on Get New user
	 * validate that first name element is displayed
	 */

	public static void main(String[] args) {
		
		setUp("Chrome", Constants.SYNTAX_PRACTICE_URL);
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Dynamic Data Loading")).click();
		driver.findElement(By.id("save")).click();
		
		//WebDriver wait or explicit wait --> waits for specific element to appear on the page
		//it will wait until expected condition is met or the specified time 
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[starts-with(text(), 'First Name'")));
		
		
		boolean isDisplayed=driver.findElement(By.xpath("//p[starts-with(text(), 'First Name'")).isDisplayed();
		if(isDisplayed) {
			System.out.println("Pass");
		}else {
			System.out.println("Failed");
		}
		
		driver.quit();
	}

}
