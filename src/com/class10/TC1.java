package com.class10;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TC1 extends CommonMethods{

	/*
	 * Navigate to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
	 * Login to the application by writing xpath based on “parent and child
	 * relation”
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("admin");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//form[@id='frmLogin']/div[5]/input")).click();

	}

}
