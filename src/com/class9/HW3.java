package com.class9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW3 extends CommonMethods{

	/*
	 * Open chrome browser Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” Login into
	 * the application Select Leave List 
	 * Select from December 1, 2019 until January 31, 2020 
	 * Check only Pending approval 
	 * Click on Search 
	 * Validate “No Records
	 * Found” is displayed Quit the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", Constants.HRMS_URL);
		String userName = "Admin";
		String password = "Hum@nhrm123";
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_leave_viewLeaveList")));
		driver.findElement(By.id("menu_leave_viewLeaveList")).click();
		
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-month']")));
		Select select=new Select(month);
		select.selectByVisibleText("Dec");
		
		WebElement year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select2=new Select(year);
		select2.selectByVisibleText("2019");
		
		List<WebElement> calendarData=driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
		
		String selectedDate="1";
		for(WebElement singleData:calendarData) {
			String dates=singleData.getText();			
				if(dates.equals(selectedDate)) {
					singleData.click();
					break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='calToDate']/following-sibling::img")).click();
		WebElement month2=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth2=new Select(month2);
		selectMonth2.selectByVisibleText("Jan");
		
		WebElement year2=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear2=new Select(year2);
		selectYear2.selectByVisibleText("2020");
		
		List <WebElement> calendarData2=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement singleData2:calendarData2) {
			String dates2=singleData2.getText();
			if(dates2.equals("31")) {
				singleData2.click();
				break;
			}
		}
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='leaveList[chkSearchFilter][]'][3]")));
		driver.findElement(By.xpath("//input[@name='leaveList[chkSearchFilter][]'][3]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='btnSearch']")).click();
		
		boolean isDisplayed=driver.findElement(By.xpath("//td[text()='No Records Found']")).isDisplayed();
		
		if(isDisplayed) {
			System.out.println("No Records Found is displayed");
		}else {
			System.out.println("No Records Found is NOT displayed");
		}
		
		driver.quit();
	}

}
