package pages;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import resources.Common;
import resources.TestManager;



public class SofaPage extends TestManager {
	public static final String desiredSfoa = "Urban Ladder";
	String sofaLocator = "//b[contains(text(),'"+desiredSfoa+"')]";
	WebDriver driver = getDriverInstance();
	public void detailsSofa() {
		  WebDriverWait wait = new WebDriverWait(driver, 20);	
          WebElement sofaEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Common.sofaIcon)));
          sofaEle.click();
	}

    public void addSofa() {
	      List<WebElement> sofas = driver.findElements(By.xpath("//div[@class='col-sm-4 ng-star-inserted']"));
	      ListIterator<WebElement> sofasIt = sofas.listIterator();
	      while(sofasIt.hasNext()) {
				if(sofaPresent()==true) {
					driver.findElement(By.xpath(sofaLocator)).click();
					break;
				}
				else {
					driver.findElement(By.xpath("//a[@aria-label='Next page']")).click();
				}
			}
}
    public boolean sofaPresent() {
		try {

			driver.findElement(By.xpath(sofaLocator));
			return true;
		}
		catch(NoSuchElementException nse){
			return false;
		}

	}
    
    
	
}
