package resources;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class DriverSource  {
	
	public static HashMap<String, WebDriver> driverInstance = new HashMap<String, WebDriver>();
	
	
	@BeforeTest()
	public void newDriver() {
		
 		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Softwares\\chromedriver.exe");
 		WebDriver driver = new ChromeDriver();
		driverInstance.put("driverInst", driver);
		
		
	}
	
	public WebDriver getDriverInstance() {
		
		return driverInstance.get("driverInst");
		
		
	}
	
	@AfterSuite
	public void closeWindow() {
		WebDriver chromedriver = getDriverInstance();
		chromedriver.close();
	}
	
	
	
}
