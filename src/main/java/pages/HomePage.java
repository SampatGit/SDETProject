package pages;

import static org.testng.Assert.assertTrue;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Common;
import resources.DriverSource;
import testResources.TestManager;

public class HomePage extends TestManager {
	
	WebDriver chromedriver = DriverSource.driverInstance.get("driverInst");
	
	public void openChairDetails() throws InterruptedException {
		//This code will Click on chair icon in homepage
		Thread.sleep(2000);
		Thread.sleep(3000);
		WebElement element = chromedriver.findElement(By.xpath(Common.chairIcon));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(7000);
	}
	
	public void iTakeYouHomeAnyTime() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(getDriverInstance(), 20);
		WebElement home = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='navbar-brand']")));
		home.click();
		Thread.sleep(3000);
		
	}
}
