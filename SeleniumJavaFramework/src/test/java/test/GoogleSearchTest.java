package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {

		googleSearch();
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath  + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//goto google.com
		driver.get("https://google.com");
		
		//enter text in search text box
		GoogleSearchPage.textbox_search(driver).sendKeys("Motley Fool");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//click on search btn
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		// window will wait for 5secs before closing
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//close browser
		driver.close();
		
		System.out.println("Test completed successfully");
	}
}

//Examples form Test1_GoogleSearch

//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
//driver.findElement(By.name("btnK")).click();
//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
//driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
//driver.findElement(By.xpath("//input[@name='btnK']")).click();
