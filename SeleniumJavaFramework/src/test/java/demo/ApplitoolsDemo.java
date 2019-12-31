package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

public class ApplitoolsDemo {

	public static void main(String[] args) {
		//Open Chrome Browser
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Initialize the eyes SDK
		Eyes eyes = new Eyes();

		// Change the APPLITOOLS_API_KEY API key with yours
		eyes.setApiKey("APPLITOOLS_API_KEY");
		
		try {
			// Set AUT's name, test name and viewport size (width X height)
			// We have set it to 800 x 600 to accommodate various screens. Feel free to
			// change it.
			eyes.open(driver, "Hello World!", "My first Selenium Java test", new RectangleSize(800, 600));

			// Navigate the browser to the Applitools Hello World demo app.
			driver.get("https://applitools.com/helloworld");
			
			// Visual checkpoint #1
			eyes.checkWindow("Hello!");
			
			//Click the Click Me! button
			driver.findElement(By.tagName("button")).click();
			
			//Visual checkpoint #2
			eyes.checkWindow("Click!");
			
			//End test
			eyes.close();
			
		} finally {
			driver.close();
		}
		
	}

}
