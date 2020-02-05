package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	
	public static final String WebUrl = "http://okmry52647dns.eastus.cloudapp.azure.com:9090";
	public static final String SwaggerUrl = "http://okmry52647dns.eastus.cloudapp.azure.com:8089/swagger-ui.html";
	WebDriver driver = new ChromeDriver();
	public static final String signIn = "(//span[@class='mat-button-wrapper'])[6]";
	public static final String email = "sdet115@gmail.com";
	public static final String password = "Sdet@2020";
	public static final String submitDetails = "//div/button[@type='submit']/../button[text()='Sign In']";
	public static final String logText = "Successfull";
	public static final String chairIcon = "//div[@class='circle-text-chair']";
	public static final String sofaIcon = "//div[@class='circle-text-sofa']";
	public static final String AllProfilePath = "rest/api/profile/all";
	public static final String CartBasePath = "/rest/api/cart/";
	public static final String WishListBasePath = "/rest/api/wishlist/";
	
	
	
	public void commonVariables() {
	
		
	
	}
	
}
