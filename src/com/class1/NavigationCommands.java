package com.class1;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) {

		// http--? Hyper Text Transfer Protocol Source

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// visit a site
		driver.get("http://www.google.com");
		// Thread.sleep(1000); not necessary, just using to as an example

		// browser navigation commands

		// Navigate to given URL
		driver.navigate().to("http://www.youtube.com");
		// Navigate back
		driver.navigate().back();
		// Navigate one step forward
		driver.navigate().forward();
		// Refresh page
		driver.navigate().refresh();

		String actualTittle = driver.getTitle();
		System.out.println(actualTittle);

		driver.close();

	}

}
