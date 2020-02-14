package pages;

import java.util.List;
import testResources.TestManager;
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




public class SofaPage extends TestManager {
	public static final String desiredSfoa = "Urban Ladder";
	String sofaLocator = "//b[contains(text(),'"+desiredSfoa+"')]";
	WebDriver driver = getDriverInstance();
	public void detailsSofa() {
		  WebDriverWait wait = new WebDriverWait(getDriverInstance(), 20);	
          WebElement sofaEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Common.sofaIcon)));
          sofaEle.click();
	}

    public void addSofa() {
    	  WebDriverWait wait = new WebDriverWait(getDriverInstance(),20);
	      List<WebElement> sofas = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//b[@class='float-left text-wrap fname']")));
	    
	      ListIterator<WebElement> sofasIt = sofas.listIterator();
	      while(sofasIt.hasNext()) {
				if(sofaPresent()==true) {
					getDriverInstance().findElement(By.xpath(sofaLocator)).click();
					break;
				}
				else {
					getDriverInstance().findElement(By.xpath("//a[@aria-label='Next page']")).click();
				}
			}
}
    public boolean sofaPresent() {
		try {

			getDriverInstance().findElement(By.xpath(sofaLocator));
			return true;
		}
		catch(NoSuchElementException nse){
			return false;
		}

	}
    
    
	
}
