package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class HW2 extends CommonMethods {
	
	/*
	 *Open chrome browser
	*Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
	*Login to the application
	*Verify customer “Susan McLaren” is present in the table
	Click on customer details
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		List <WebElement> rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		String expectedValue="Susan McLaren";
		for(int i=0; i<rows.size();i++) {
			String elements=rows.get(i).getText();
			if(elements.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+i+"]/td[13]")).click();
			}
		}

	}

}
