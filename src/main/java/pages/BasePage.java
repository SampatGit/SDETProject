package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.DriverSource;
import testResources.TestManager;

public class BasePage extends TestManager {
	

	WebElement element;
	List<WebElement> elements;
	
    public WebElement clickWebElement(String locator, String locValue) {
    	WebDriverWait wait = new WebDriverWait(getDriverInstance(), 30);
    	if(locator.equalsIgnoreCase("xpath")) {
    		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locValue)));
    	
    	}
    	else if(locator.equalsIgnoreCase("id")) {
    		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locValue)));
    	}
    	
    	return element;
    	
    }
    
    public List<WebElement> selectElements (String locator, String locValue){
    	WebDriverWait wait = new WebDriverWait(getDriverInstance(), 30);
    	if(locator.equalsIgnoreCase("xpath")) {
    		elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locValue)));
    	
    	}
    	else if(locator.equalsIgnoreCase("id")) {
    		elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locValue)));
    	}
    	return elements;
    }
	
}
