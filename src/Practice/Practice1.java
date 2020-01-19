package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Shifting Content")).click();
		driver.findElement(By.xpath("//a[text()='Example 1: Menu Element']")).click();
		List<WebElement> el=driver.findElements(By.tagName("li"));
		System.out.println("The number of item in: "+el.size());
		
		driver.quit();
		

	}

}
