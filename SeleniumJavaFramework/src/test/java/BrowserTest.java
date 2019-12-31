import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.get("https://google.com/");
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();		
		cdriver.get("https://google.com/");
		
		WebElement searchInput = cdriver.findElement(By.name("q"));
		searchInput.sendKeys("Automation Step by Step");		
//		cdriver.findElement(By.name("q")).sendKeys("abcd"); //-->same as above statement
		
		List<WebElement> listOfInputElements = cdriver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size();
		System.out.println("Count of input elements is = "+count);
		
		// window will wait for 3secs before closing
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdriver.close(); // -->closes this instance of chromedriver
//		driver.close();
//		driver.quit();  -->closes all chrome drivers		
	} 
}
