package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWaitDemo {
	
/*What is implicit wait - Used to define a time period until when webdriver should wait before throwing No Such Exception
 * 
 * Syntax: driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * note: By default is set to 0
 * implicit wait is applicable for the entire browser session
 */

	public static void main(String[] args) {
		SeleniumWaits();
	}
	
	public static void SeleniumWaits() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//250ms is the default pull time of implicit wait
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.name("abcd")).click();
		
		driver.close();
		driver.quit();
	}

}
