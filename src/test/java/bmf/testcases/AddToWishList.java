package bmf.testcases;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pages.SofaPage;
import pages.WishListPage;
import resources.TestManager;

public class AddToWishList extends TestManager {
	
	
	//This Scenario will verify adding a Sofa to Wishlist and verifying it
	@Test
	public  void verifyWishList() throws JsonMappingException, JsonProcessingException {
		SofaPage sofobj = new SofaPage();
		WishListPage wishList = new WishListPage();
		sofobj.detailsSofa(); 
		sofobj.addSofa();
		
		wishList.addToWIshList();
		wishList.verifyWishList();
		wishList.verifyWishListAPI(SofaPage.desiredSfoa);
		
	}

}
