package bmf.testcases;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pages.ChairsPage;
import pages.SofaPage;
import pages.WishListPage;
import resources.TestManager;

//This test will add multiple items to the wishlist and verify if it is present 

public class AddMultipleItemsWishlist extends TestManager {
	ChairsPage chair = new ChairsPage();
	SofaPage sofa = new SofaPage();
	WishListPage addWishList = new WishListPage();
	
	@Test
	
	public void verifyWishList() throws InterruptedException, JsonMappingException, JsonProcessingException {
		chair.chairDetails();
		chair.AddChairToCart();
		addWishList.addToWIshList();
		sofa.detailsSofa();
		sofa.addSofa();
		addWishList.addToWIshList();
		addWishList.verifyWishListAPI(ChairsPage.desiredChair);
		addWishList.verifyWishListAPI(SofaPage.desiredSfoa);
		
		
	}
}
