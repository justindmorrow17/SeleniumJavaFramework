package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under
		ExtentTest test1 = extent.createTest("Google Search Test 1", "test to validate google search functionality");

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting test case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Motley Fool");
		test1.pass("Entered text in Searchbox");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Test Completed");

		// calling flush writes everything to log file
		extent.flush();

		ExtentTest test2 = extent.createTest("Google Search Test 2", "test to validate google search functionality");

		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		test2.log(Status.INFO, "Starting test case");
		driver.get("https://google.com");
		test2.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Motley Fool");
		test2.pass("Entered text in Searchbox");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test2.fail("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test2.pass("Closed the browser");
		test2.info("Test Completed");

		extent.flush();
//		// short-hand
//		extent.createTest("MyFirstTest").pass("details");
//			
//		// description
//		extent.createTest("MyFirstTest", "Test Description").pass("details");
	}

}
