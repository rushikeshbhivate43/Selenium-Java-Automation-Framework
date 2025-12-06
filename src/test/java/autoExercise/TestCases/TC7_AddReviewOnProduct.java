package autoExercise.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.ProductsDetailsPage;
import autoExercise.PageObjets.ProductsPage;
import autoExercise.Utilities.BaseClass;

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
