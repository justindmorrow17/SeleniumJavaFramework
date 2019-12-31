package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsWithTestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	private static WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() {

		// creates a toggle for the given test, adds all log events under
		ExtentTest test1 = extent.createTest("Google Search Test 1", "test to validate google search functionality");
		
		test1.log(Status.INFO, "Starting test case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Motley Fool");
		test1.pass("Entered text in Searchbox");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Test Completed");

	}

	@AfterTest
	public void tearDown() {

		extent.flush();
	}
}
