package com.AutoExercise.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AutoExercise.PageObjets.HomePage;
import com.AutoExercise.PageObjets.ProductsDetailsPage;
import com.AutoExercise.PageObjets.ProductsPage;
import com.AutoExercise.PageObjets.ViewCartPage;
import com.AutoExercise.Utilities.BaseClass;

public class TC6_VerifyProductQauntityInCart extends BaseClass  {

	@Test
	public void verifyProductQuanitytInCart() throws InterruptedException
	{

		TC2_LoginUser login = new TC2_LoginUser();
		login.verifyLoginUser();

		logger.info("Starting test: verify product quantity in cart");

		HomePage homePage = new HomePage(driver);
		homePage.products();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.viewProduct();

		ProductsDetailsPage productDetails = new ProductsDetailsPage(driver);
		productDetails.quantity("4");
		productDetails.addToCart();
		logger.info("Product quantity set to 4 and added to cart.");

		productsPage.viewCart();

		ViewCartPage viewCart = new ViewCartPage(driver);
		String ProductQuantity = viewCart.getProductQuantity();
		logger.info("Quantity displayed in cart: {}", ProductQuantity);

		if (ProductQuantity.equalsIgnoreCase("4")) {

			logger.info("Product quantity matched successfully.");

		} else {

			logger.error("Product quantity mismatch. Expected: 4, Found: {}", ProductQuantity);
			logger.info("Removing product due to mismatch.");
			viewCart.removeProduct();
			logger.info("Removed product from cart to maintain clean state for next test run.");
			Assert.fail("Product quantity is not displayed correctly in cart.");

		}

		viewCart.removeProduct();
		logger.info("Removed product from cart to maintain clean state for next test run.");
		logger.info("Ended test: verify product quantity in cart");
	}
}
