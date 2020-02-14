package bmf.testcases;

import java.io.IOException;



import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pages.ChairsPage;
import pages.HomePage;
import pages.SofaPage;
import pages.WishListPage;
import testResources.TestManager;
import utils.Reporting;

//This test will add multiple items to the wishlist and verify if it is present 

public class AddMultipleItemsWishlist extends TestManager {
	ChairsPage chair = new ChairsPage();
	SofaPage sofa = new SofaPage();
	WishListPage addWishList = new WishListPage();
	HomePage home = new HomePage();
	Reporting rng = new Reporting();


	@Test(groups= {"regression"})
	public void verifyWishList() throws Exception {
        
		rng.capture(getDriverInstance(), "beforeClickingChair");
		chair.chairDetails();
		rng.capture(getDriverInstance(), "afterClickingChair"); 
		//logger.info("adding chair to Wishlist");
		rng.capture(getDriverInstance(), "beforeClickingAddWishList"); 
		addWishList.addToWIshList();
		rng.capture(getDriverInstance(), "afterAddingWishlist"); 
		home.iTakeYouHomeAnyTime();
		rng.capture(getDriverInstance(), "beforeAddingSofa");
		sofa.detailsSofa();
		rng.capture(getDriverInstance(), "beforeAddingSofaToWishlist");
		sofa.addSofa();
		rng.capture(getDriverInstance(), "afterAddingWishlist");
		addWishList.addToWIshList();
		addWishList.verifyWishListAPI(ChairsPage.desiredChair);
		addWishList.verifyWishListAPI(SofaPage.desiredSfoa);


	}
}
