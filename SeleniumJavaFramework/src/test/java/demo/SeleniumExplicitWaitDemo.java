package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExplicitWaitDemo {
	
/*What is explicit wait - can be set for specific elements, can be set for a specific condition IE wait until element is clickable
 * 
 * Syntax: WebDriverWait wait = new WebDriverWait(driver, 10);
 * WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("abc")));
 * 
 */

	public static void main(String[] args) {
		SeleniumWaits();
	}
	
	public static void SeleniumWaits() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); *implicit wait
		//250ms is the default pull time of implicit wait
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		
		driver.findElement(By.name("abcd")).click();
		
		driver.close();
		driver.quit();
	}

}
