package com.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class HW4 extends CommonMethods{

	/*
	 * Open chrome browser 
	 * Go to  “http://166.62.36.207/humanresources/symfony/web/index.php/auth” 
	 * Login into the application 
	 * Add Employee 
	 * Log out 
	 * Quit the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		// login into HRMS
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		//add employee
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		Thread.sleep(3000);
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='menu_pim_addEmployee']")));
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Ann");
		driver.findElement(By.id("lastName")).sendKeys("Caballero");
		String empId=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.id("welcome")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='welcome-menu']/ul/li[3]/a")));
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.quit();

	}

}
