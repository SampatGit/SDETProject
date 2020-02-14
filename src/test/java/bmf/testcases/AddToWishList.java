package bmf.testcases;

import java.io.IOException;

import org.testng.annotations.Test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pages.SofaPage;
import pages.WishListPage;
import testResources.TestManager;
import utils.Reporting;

public class AddToWishList extends TestManager {
	
	
	Reporting reporter = new Reporting();
	//This Scenario will verify adding a Sofa to Wishlist and verifying it
    @Test
	public  void verifyWishList() throws IOException {
		SofaPage sofobj = new SofaPage();
		WishListPage wishList = new WishListPage();
		reporter.capture(getDriverInstance(), "Logged in Snapshot");
		sofobj.detailsSofa();
		reporter.capture(getDriverInstance(), "Sofa Details");
		sofobj.addSofa();
		reporter.capture(getDriverInstance(), "Add Sofa to Wishlist");
		wishList.addToWIshList();
		reporter.capture(getDriverInstance(), "Added sofa to wishlist");
		wishList.verifyWishList();
		reporter.capture(getDriverInstance(), "Verify Sofa in Wishlist");
		wishList.verifyWishListAPI(SofaPage.desiredSfoa);
		
	}

}
