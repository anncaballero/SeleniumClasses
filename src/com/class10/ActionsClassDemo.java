package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ActionsClassDemo extends CommonMethods {
	
	/*
	 * Navigate to HRMS application
	 * enter UserID and pwd
	 * click on login using mouse
	 */

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		
		//to perform mouse or keyboard operations we need to have an object of the Actions class
		Actions act=new Actions(driver);
		
		//identify an element to perform mouse click
		WebElement loginBtn=driver.findElement(By.cssSelector("input#btnLogin"));
		
		//clicking on the mouse and to complete the action we need to call the perform method
		act.moveToElement(loginBtn).click().perform();
		
		//to perform double click
		act.moveToElement(loginBtn).doubleClick().perform();
		
		//to perform right click
		act.moveToElement(loginBtn).contextClick().perform();
		
		//to hover over the element
		WebElement pimLink=driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimLink).perform();
		
		//click on the Add Employee link 
		WebElement addEmp=driver.findElement(By.linkText("Add Employee"));
		//      parameter of focused element
		act.click(addEmp).perform();
		
		//in text box it will call shift key and type hello in upper case
		act.keyUp(Keys.SHIFT).sendKeys("hello");
		
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
