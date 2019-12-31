package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;



public class TestNG_Demo {

	private static WebDriver driver = null;
	public static String browserName = null;
//	private static Logger logger = LogManager.getLogger(Log4jDemo.class);

	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();			
		}
	}

	@Test
	public static void googleSearch() {

		// goto google.com
		driver.get("https://google.com");

		// enter text in search text box
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// click on search btn
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		// window will wait for 5secs before closing
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDownTest() {
		// close browser
		driver.close();

		System.out.println("Test completed successfully");
		PropertiesFile.setProperties();
	}

}
