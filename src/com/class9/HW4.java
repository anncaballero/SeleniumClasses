package com.class9;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class HW4 extends CommonMethods {

	/*
	 * Open chrome browser Go to “https://www.aa.com/homePage.do” Enter From and To
	 * Select departure as May 14 of 2020 Select arrival as November 8 of 2020
	 * Verify “Choose flights” text is displayed Take s screenshot of the results
	 * Close browser
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "https://www.aa.com/homePage.do");
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']")).clear();
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']")).sendKeys("BWI");
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']")).sendKeys("LAX");
		driver.findElement(By.xpath("//input[@id='aa-leavingOn']//following-sibling::button")).click();
		
		boolean departure=false;
		while(!departure) {
			
		}

	}

}
