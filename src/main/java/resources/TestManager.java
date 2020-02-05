package resources;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import pages.HomePage;
import utils.Reporting;

public class TestManager extends DriverSource {
	
			WebDriver chromedriver;
			Reporting reporter = new Reporting();
	
	@BeforeTest
	public void verifyLogin() throws InterruptedException, IOException {
			chromedriver=getDriverInstance();
			
			getDriverInstance().get(Common.WebUrl);
			getDriverInstance().manage().window().maximize();
			WebDriverWait signInWait = new WebDriverWait(getDriverInstance(),190);
			WebElement element = signInWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Common.signIn)));
					
			element.click();
			Thread.sleep(2000);
			element = signInWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailId")));
			reporter.screenCapture(getDriverInstance());
		    //element = getDriverInstance().findElement(By.id("emailId"));
			element.sendKeys(Common.email);
			reporter.screenCapture(getDriverInstance());
			element = getDriverInstance().findElement(By.id("password"));
			element.sendKeys(Common.password);
			Thread.sleep(3000);
			element = getDriverInstance().findElement(By.xpath(Common.submitDetails));
			element.click();
			Thread.sleep(3000);
		//	assertTrue(getDriverInstance().getPageSource().contains(Common.logText));
			
			}
	
	
	
	

	
	
	
	}
	
