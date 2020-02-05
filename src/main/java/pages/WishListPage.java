package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.response.Response;
import resources.Common;
import resources.SpecBuilder;
import resources.TestManager;

public class WishListPage extends TestManager {
	
	public String wishListBtn = "//button[@class='btn btn-outline-warning space ng-star-inserted' and text()='Add to Wishlist ']";
	public String wishlistIcon = "//span[@class='mat-button-wrapper' and text()=' Wishlist ']";
	public String WishListJsonPath = "body.product.name";
	WebDriver driver = getDriverInstance();
	SpecBuilder builder = new SpecBuilder();
	GetResponse resp = new GetResponse();
	
	public void addToWIshList() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wishListBtn)));
		element.click();
		assertTrue(driver.getPageSource().contains(Common.logText));
	}
	
	public void verifyWishList() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wishlistIcon)));
		element.click();
	}
	
	@Test
	public void verifyWishListAPI(String desName) throws JsonMappingException, JsonProcessingException {
		int UserId = resp.GetUserID();
		Response resp = builder.setRequest(Common.WishListBasePath+UserId);
		String sofaName = resp.jsonPath().get(WishListJsonPath).toString();
		assertTrue(sofaName.contains(desName));
		
		
		
	}

}
