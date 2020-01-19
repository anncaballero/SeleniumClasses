package com.class7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class PageLoadandImplicitWait extends CommonMethods {

	public static void main(String[] args) {
		
		setUp("chrome", "https://www.cnn.com/");
		
		//pageLoadTimeout waits until all elements in the page are fully loaded and
		//if elements do not load within the given time you will get an exception.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//tell the WebDriver to wait for the element before throwing NoSuchElement exception
		//we need Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("wrongName")).sendKeys("iPhone");
		
		driver.quit();

	}

}
