package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Common;
import resources.DriverSource;

public class HomePage {
	
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
}
