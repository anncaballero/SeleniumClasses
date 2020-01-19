package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class Task1 extends CommonMethods {

	/*
	 * Open chrome browser Go to “http://166.62.36.207/syntaxpractice/” 
	 * Click on “Table” link 
	 * Click on “ITable Data Search” link 
	 * Verify second table consist of 4 rows and 5 columns 
	 * Print name of all column headers 
	 * Print data of all rows 
	 * Quit Browser
	 */

	public static void main(String[] args) {
		
		setUp("chrome", "http://166.62.36.207/syntaxpractice/");
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		int expectedCols=4;
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		int actualCols=cols.size();
		
		if(actualCols==expectedCols) {
			System.out.println("---The number of columns matches expected number---");
		}else {
			System.out.println("The number of columns does not match expected number");
		}
		for(WebElement colNames:cols) {
			System.out.println(colNames.getText());
		}
		
		int expectedRows=5;
		List<WebElement>rows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		int actualRows=rows.size();
		
		if(actualRows==expectedRows) {
			System.out.println("---The number of rows matches expected number---");
		}else {
			System.out.println("The number of columns does not match expected number");
		}
		
		for(WebElement rowNames:rows) {
			System.out.println(rowNames.getText());
		}
		System.out.println("---Printing data cell by cell---");
		
		List<WebElement> cells=driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));
		
		for(WebElement cell:cells) {
			String c=cell.getText();
			System.out.println(c);
		}
		
		System.out.println("----Printing Data Cell By Cell Using Advanced For Loop---------------");
		for (int i = 1; i<=actualRows; i++) {			//Controlling the rows
			for (int y =1; y<=actualCols; y++) {		//Controlling the cols
				String cellText = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td["+y+"]")).getText();
				System.out.println(cellText);
			}
		}
		driver.quit();

	}

}
