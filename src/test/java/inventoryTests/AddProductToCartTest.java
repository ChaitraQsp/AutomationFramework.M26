package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException
	{
		// Read Test Data From Excel File
		String PRODUCTNAME = fUtil.readDataFromExcel("Product", 1, 2);

		// Step 4: Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);

		// Step 5: Add the Product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Step 6: Navigate to Cart
		ip.clickOnCartContainer();
		
		//Assert.fail();

		// Step 7: Validate the product in Cart
	    CartPage cp = new CartPage(driver);
	    String pInCart = cp.getProductName();
	    
	    Assert.assertEquals(pInCart, pAddedToCart);
	    
	    Assert.assertTrue(pInCart.equals(pAddedToCart));
	    
	    System.out.println(pInCart);
//		
//		if (pInCart.equals(pAddedToCart)) {
//			System.out.println("PASS");
//			System.out.println(pInCart);
//		} else {
//			System.out.println("FAIL");	}
//		
	    //@Test - priority, invocation count, enabled = fasle, dependsOnMethods
	    //dataprovider
	

	}

}
