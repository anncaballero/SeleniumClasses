package com.class9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class HW1 extends CommonMethods {

	/*
	 * Open chrome browser Go to
	 * “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.
	 * aspx” Login to the application Verify customer “Susan McLaren” is present in
	 * the table Click on customer details Update customers last name and credit
	 * card info Verify updated customers name and credit card number is displayed
	 * in table Close browser
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		String expectedName = "Susan McLaren";

		List<WebElement> data = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

		String updatedValue = "Susan abcd";

		for (int i = 1; i < data.size(); i++) {
			String tableData = data.get(i - 1).getText();
			if (tableData.contains(expectedName)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + i + "]/td[13]"))
						.click();

				driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(updatedValue);
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).clear();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5416549584958");
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).clear();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("08/20");
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

				break;
			}
		}

		List<WebElement> updatedData = driver
				.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

		String updatedCC = "American Express 5416549584958 08/20";

		for (WebElement loop : updatedData) {
			String updatedDataLoop = loop.getText();
			if (updatedDataLoop.contains(updatedValue)) {
				System.out.println("Updating last name test has passed");
				if (updatedDataLoop.contains(updatedCC)) {
					System.out.println("Updating CC info test has passed");
					break;
				} else {
					System.out.println("CC update failed");
				}
			}
		}
		
		driver.findElement(By.linkText("Logout"));
		Thread.sleep(3000);
		 driver.close();

	}
}
