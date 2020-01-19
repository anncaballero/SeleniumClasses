package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class ExplicitWaitDemo2 extends CommonMethods {
	
	/*
	 * navigate to google
	 * search for Wegmans
	 * click on link "Wegmans Grocery Delivery | Powered by Instacart"
	 * once we are redirected to the site, click "Log In"
	 */

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://www.google.com/");
		
		//send Wegmans text and hit enter
		driver.findElement(By.name("q")).sendKeys("Wegmans", Keys.ENTER);
		
		//click on first link results page
		driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in")));
		
		//click on login
		driver.findElement(By.id("sign-in")).click();
		System.out.println("-----Link was clicked------");
		
		Thread.sleep(3000);
		driver.quit();

	}

}
