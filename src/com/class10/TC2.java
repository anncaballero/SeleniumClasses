package com.class10;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TC2 extends CommonMethods {

	/*
	 * Navigate to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
	 * Login to the application by writing xpath based on “following and preceding
	 * siblings”
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.findElement(By.xpath("//span[@class='form-hint']/preceding-sibling::input")).sendKeys("admin");
		driver.findElement(By.xpath("//span[text()='Password']/preceding-sibling::input")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();


	}

}
