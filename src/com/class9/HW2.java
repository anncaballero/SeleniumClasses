package com.class9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class HW2 extends CommonMethods{

	/*
	 * Open chrome browser Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” 
	 * Login into the application 
	 * Add Employee 
	 * Verify Employee has been added 
	 * Go to Employee List 
	 * Delete added Employee 
	 * Quit the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		String userName = "Admin";
		String password = "Hum@nhrm123";
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		String empNam="Ann";
		String empLastName="Caballero";
		driver.findElement(By.id("firstName")).sendKeys(empNam);
		driver.findElement(By.id("lastName")).sendKeys(empLastName);
		driver.findElement(By.id("btnSave")).click();
		String empAddedName=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		if(empAddedName.contains(empNam+" "+empLastName)) {
			System.out.println("Employee has been successfully added");
		}else {
			System.out.println("Employee was not added");
		}
		
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		boolean found=false;
		while(!found) {
			List<WebElement> employeeList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			Thread.sleep(4000);
			for(int i=1; i<=employeeList.size();i++) {
				String rowsText=employeeList.get(i-1).getText();
				if(rowsText.contains(empNam)) {
					found=true;
					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("btnDelete")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("dialogDeleteBtn")).click();
					break;
				}
			}
			//if emp id was not found in the first page --> click next
			//driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		driver.quit();
 		}

	}

