import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		System.setProperty("webdriver.ie.driver", projectPath + "\\drivers\\iedriver\\IEDriverServer.exe");
		WebDriver iedriver = new InternetExplorerDriver(caps);
		iedriver.get("https://google.com");
		iedriver.findElement(By.name("q")).sendKeys("abcd");
		iedriver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}

}
