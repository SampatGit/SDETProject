package pages;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testResources.TestManager;
import utils.DataReader;
import resources.Common;




public class ChairsPage extends TestManager {

	WebDriver driver = getDriverInstance();

	public static String desiredChair = "Nilkamal";
	String chairLocator = "//b[contains(text(),'"+desiredChair+"')]";
	String addCartLocator = "//button[@class='btn btn-outline-success space ng-star-inserted']";
	public static final String CartLocator = "//span[@class='mat-button-wrapper' and text()=' Cart ']";
	
	BasePage basePage = new BasePage();
	DataReader dataReader = new DataReader();




	public void chairDetails() throws Exception {
		Thread.sleep(10000);
		WebElement element = basePage.clickWebElement("xpath", dataReader.getData("chairIcon"));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(7000);
		
		List<WebElement> chairs = basePage.selectElements("xpath",  dataReader.getData("allChairs"));
		Thread.sleep(2000);
		ListIterator<WebElement> chairIt = chairs.listIterator();
		while(chairIt.hasNext()) {
			if(chairPresent()==true) {
				getDriverInstance().findElement(By.xpath(chairLocator)).click();
				break;
			}
			else {
				getDriverInstance().findElement(By.xpath("//a[@aria-label='Next page']")).click();
			}
		}


	}

	public boolean chairPresent() {
		try {

			getDriverInstance().findElement(By.xpath(chairLocator));
			return true;
		}
		catch(NoSuchElementException nse){
			return false;
		}

	}
	
	

	public void AddChairToCart() throws InterruptedException {
		
		Properties props = new Properties();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriverInstance(),20);

		WebElement addCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCartLocator)));
		addCart.click();
		//	assertTrue(getDriverInstance().getPageSource().contains(Common.logText));


	}

	public void VerifyItemAdded() throws InterruptedException {
		WebElement CartAdd = getDriverInstance().findElement(By.xpath(CartLocator));
		CartAdd.click();
		Thread.sleep(2000);
		WebElement cart = getDriverInstance().findElement(By.xpath("//div[@class='name']"));
		assertTrue(cart.getText().contains(desiredChair));
	}
	
	

}
