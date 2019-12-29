package com.class5;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class DropDownRecap extends CommonMethods {
	
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		//find the element input form and click on it
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(2000);
		
		//find the element select dropdown list and click on it
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		//find the element with id select-demo and stgore it in a variable
		WebElement dd=driver.findElement(By.id("select-demo"));
		
		//to work with dd, if the tagname start with object, then create an object of select class
		Select select=new Select(dd);
		//select desired index
		select.selectByIndex(3);
		//select value by visible text
		select.selectByVisibleText("Friday");
		//selecting value by finding the value attribute
		select.selectByValue("Sunday");
		
		//how to get the count of a dropdown items?
		
		
		//call the getOptions(); method and store it into a list
		List<WebElement> options=select.getOptions();
		
		//using the size(); method cfoming from the list
		System.out.println(options.size());
		
		//looping through all the List elements to select each element of the dropdown
		Iterator<WebElement> it=options.iterator();
		while(it.hasNext()) {
			it.next().click();
			Thread.sleep(2000);
		}
		
		System.out.println("Does this dd support multi select? The answer is  "+select.isMultiple());

	}

}
