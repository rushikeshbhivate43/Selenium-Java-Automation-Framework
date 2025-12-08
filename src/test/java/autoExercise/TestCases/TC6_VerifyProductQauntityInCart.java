package autoExercise.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.ProductsDetailsPage;
import autoExercise.PageObjets.ProductsPage;
import autoExercise.PageObjets.ViewCartPage;
import autoExercise.Utilities.BaseClass;

/**
 * Test Case: Verify product quantity in cart.
 * Steps:
 * 1. Login by user
 * 2. Navigate to the Product page.
 * 3. Click on View Product.
 * 4. Increase the product quantity
 * 5. click on view cart
 * 6. Get the product quantity on cart page.
 * 7. Compare the quanity.
 * 8. Removed product from cart to maintain clean state for next test run.
 */

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
