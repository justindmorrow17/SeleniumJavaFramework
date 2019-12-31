package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("I am inside test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside test 2");

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();		
		cdriver.get("https://google.com/");
		cdriver.findElement(By.name("q")).sendKeys("abcd"); //-->same as above statement
//		cdriver.findElement(By.name("xyz")).sendKeys("abcd");
		
		cdriver.close();
		}
	
	@Test
	public void test3() {
		System.out.println("I am inside test 3");
		throw new SkipException("This test is skipped");
	}
}
