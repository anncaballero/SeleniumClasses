package com.class6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RecapRadioAndCheck extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		//handle 1 radio or checkbox
		driver.findElement(By.xpath("//input[@type='checkbox'")).click();
		
		//handle a group of radio or checkbox
		List<WebElement> allChBoxes=driver.findElements(By.xpath("//input[@type='checkbox'"));
		for(WebElement ell:allChBoxes) {
			String text=ell.getAttribute("value");
			if(text.equals("Selenium IDE")) {
				ell.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.close();

	}

}
