package com.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class HW extends CommonMethods{

	/*
	 * Open chrome browser Go to “https://the-internet.herokuapp.com/” Click on
	 * “Click on the “Dynamic Controls” link Select checkbox and click Remove Click
	 * on Add button and verify “It’s back!” text is displayed Close the browser
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form/p[@id='message']")));
		boolean isDisplayed=driver.findElement(By.xpath("//form/p[@id='message']")).isDisplayed();
		if(isDisplayed) {
			System.out.println("“It’s back!” text is displayed");
		}else {
			System.out.println("“It’s back!” text is not displayed");
		}
		
		driver.close();

	}

}
