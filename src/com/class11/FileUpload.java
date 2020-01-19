package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class FileUpload extends CommonMethods{
	
	/*
	 * Navigate to "https://the.internet.herokuapp.com/upload"
	 * upload a file
	 * confirm File Uploaded is displayed
	 */
	
	//

	public static void main(String[] args) {
		
		setUp("chrome", "https://the-internet.herokuapp.com/upload");
		
		//to upload file we cna use sendKeys method and profile full path to the file
		//full path -->  path + fileName + fileExtension
		//for Mac use /
		//for Windows use \\ or /
		
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\anncaballero\\Desktop\\koala.jpg");
		
		//clicking on upload button
		driver.findElement(By.id("file-submit")).click();
		
		//verify element file upload is displayed
		WebElement uploaded=driver.findElement(By.xpath("//div[@id='uploaded-files']/preceding-sibling::h3"));
		
		if(uploaded.isDisplayed()) {
			System.out.println("file successfully uploaded");
		}else {
			System.out.println("File is not uploaded");
		}
		
		driver.quit();
	}

}
