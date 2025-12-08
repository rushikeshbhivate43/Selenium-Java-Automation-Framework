package autoExercise.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.ProductsDetailsPage;
import autoExercise.PageObjets.ProductsPage;
import autoExercise.Utilities.BaseClass;

/**
 * Test Case: Verify product quantity in cart.
 * Steps:
 * 1. Login by user
 * 2. Navigate to the Product page.
 * 3. Click on view product.
 * 4. Enter name, email & review.
 * 5. Click on Submit button.
 * 6. Verify the success msg is displayed.
 */
public class TC7_AddReviewOnProduct extends BaseClass{

	@Test
	public void addReviewOnProduct()
	{
		TC2_LoginUser login = new TC2_LoginUser();
		login.verifyLoginUser();

		logger.info("Starting test: add review product");

		HomePage homePage = new HomePage(driver);
		homePage.products();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.viewProduct();
		
		ProductsDetailsPage productDetails = new ProductsDetailsPage(driver);
		productDetails.name("Aatreya");
		productDetails.email("AatreyaSharma@gmail.com");
		productDetails.addReviewHere("Excellent Product!");
		productDetails.submit();

		Assert.assertTrue(productDetails.verifySuccessMsg(), "Success message not displayed!");
	    logger.info("Ending Test: Add review product");

	}
}
