package pages;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.response.Response;
import resources.Common;
import resources.DriverSource;
import resources.SpecBuilder;
import bmf.testcases.*;
import testResources.TestManager;
public class CartPage extends TestManager {
	
	SpecBuilder builder = new SpecBuilder();
	GetResponse getres = new GetResponse();
	public void VerifyItemAdded() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(getDriverInstance(),20);
		
		WebElement CartAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ChairsPage.CartLocator)));
		CartAdd.click();
		Thread.sleep(2000);
		WebElement cart = getDriverInstance().findElement(By.xpath("//div[@class='name']"));
		assertTrue(cart.getText().contains(ChairsPage.desiredChair));
	}
	

	public void verifyItemsInCart() throws JsonMappingException, JsonProcessingException {
		int UserId = getres.GetUserID();
		Response respone = builder.setRequest(Common.CartBasePath+UserId);
		System.out.println("Cart Details for the user:"+respone.prettyPrint());
		
		
	}
	
}
