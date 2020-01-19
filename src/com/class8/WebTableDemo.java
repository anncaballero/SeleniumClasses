package com.class8;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo extends CommonMethods {

	public static void main(String[] args) {
		
		setUp("Chrome", Constants.SYNTAX_PRACTICE_URL);
		
		//navigate to the table we need
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//find how many rows of data the table has
		List <WebElement> rows=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("The number of rows in the table is "+rows.size());
		
		System.out.println("-----Printing row data-------");
		
		Iterator<WebElement> rowsIt=rows.iterator();
		while(rowsIt.hasNext()) {
			String rowData=rowsIt.next().getText();
			System.out.println(rowData);
		}
		
		//find how many columns of data the table has
		List <WebElement> cols=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("The number of cols in the table is "+cols.size());
		
		System.out.println("-----Printing cols headers------");
		
		for(WebElement el:cols) {
			String header=el.getText();
			System.out.println(header);
		}

	}

}
