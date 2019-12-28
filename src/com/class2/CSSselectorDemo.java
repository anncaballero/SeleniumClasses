package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselectorDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("username");
		
		//css=   input[name='txtUsername']
		
		//input#txtUsername  only if you have id attribute
		
		//input.button DOT (.) USE FOR CLASS, IF THERE IS SPACE BETWEEN NAMES.
		
		//input[name^='txt']    ^ represents starts with
		
		//input[name$='name']   $ represents ends with
		
		//input[id*='name']   * represents contains

	}

}
