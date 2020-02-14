package resources;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class DriverSource  {
	
	public static HashMap<String, WebDriver> driverInstance = new HashMap<String, WebDriver>();
		WebDriver driver;

		/**
		 * This function will execute before each Test tag in testng.xml
		 * @param browser
		 * @throws Exception
		 */
//		@BeforeTest
//		@Parameters("browser")
//		public WebDriver setup(String browser) throws Exception{
//			//Check if parameter passed from TestNG is 'firefox'
//			if(browser.equalsIgnoreCase("firefox")){
//			//create firefox instance
//				System.setProperty("webdriver.gecko.driver", ".\\src\\test\\java\\testResources\\geckodriver.exe");
//				driver = new FirefoxDriver();
//				return driver;
//			}
//			//Check if parameter passed as 'chrome'
//			else if(browser.equalsIgnoreCase("chrome")){
//				//set path to chromedriver.exe
//				System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\SDETProject-master\\SDETProject-master\\src\\test\\java\\testResources\\chromedriver.exe");
//				//create chrome instance
//				driver = new ChromeDriver();
//				return driver;
//			}
//			//Check if parameter passed as 'Edge'
//					else if(browser.equalsIgnoreCase("Edge")){
//						//set path to Edge.exe
//						System.setProperty("webdriver.edge.driver",".\\src\\test\\java\\testResources\\MicrosoftWebDriver.exe");
//						//create Edge instance
//						driver = new EdgeDriver();
//						return driver;
//					}
//			else{
//				//If no browser passed throw exception
//				throw new Exception("Browser is not correct");
//			}
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		}
	    @BeforeTest
		public void newDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SDETProject-master\\SDETProject-master\\src\\test\\java\\testResources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driverInstance.put("driverInst", driver);


	}
	
		
	public WebDriver getDriverInstance() {
		
		return driverInstance.get("driverInst");
//		if (browser.equalsIgnoreCase == "")
//		return setup();
//		
		
	}
	
	@AfterSuite
	public void closeWindow() {
		WebDriver chromedriver = getDriverInstance();
		chromedriver.close();
	}
	
	
	
}
