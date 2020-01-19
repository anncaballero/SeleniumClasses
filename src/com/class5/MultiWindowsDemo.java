package com.class5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class MultiWindowsDemo extends CommonMethods{

	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		
		System.out.println("Tittle of main Window: "+driver.getTitle());
		driver.findElement(By.linkText("Help")).click();
		
		//to get IDs of each window, we use getWindowHandles();
		Set <String> allwindowsID=driver.getWindowHandles();
		
		System.out.println("How many windows open "+allwindowsID.size());
		
		Iterator<String> it=allwindowsID.iterator();
		String parentW=it.next();
		String childW=it.next();
		
		System.out.println("Parent iD: "+parentW);
		System.out.println("Child iD: "+childW);
		
		driver.switchTo().window(childW);

	}

}
