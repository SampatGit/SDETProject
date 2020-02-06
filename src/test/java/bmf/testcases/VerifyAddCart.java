package bmf.testcases;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.ChairsPage;

import resources.TestManager;

//Objective of this test is to verify in UI that whether an element is added to cart successfully or not
public class VerifyAddCart extends TestManager{
	
	ChairsPage chair = new ChairsPage();
	CartPage cart = new CartPage();
    
	@Test
	public void VerifyElement() throws InterruptedException {
		
		chair.chairDetails();
		chair.AddChairToCart();
		cart.VerifyItemAdded();
		
	}
	
}
