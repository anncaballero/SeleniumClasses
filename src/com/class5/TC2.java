package com.class5;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TC2 extends CommonMethods {

	public static void main(String[] args) {

		/*
		 * Syntax Frame verification Open chrome browser Go to
		 * “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” 
		 * Click on “Others” link 
		 * Click on “Iframe” link 
		 * Click on the “Home” link inside the 1 frame Verify “Syntax logo” 
		 * is displayed in another frame 
		 * Quit browser
		 */
		
		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Iframe")).click();
		driver.switchTo().frame(0);
		
		boolean isSyntaxLogoDisplayed=driver.findElement(By.xpath("//img[@src='img/Syntax.png']")).isDisplayed();
		
		System.out.println(isSyntaxLogoDisplayed);
		
		driver.quit();
		
		
	}

}
