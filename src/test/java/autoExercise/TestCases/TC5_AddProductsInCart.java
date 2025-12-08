package autoExercise.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.ProductsPage;
import autoExercise.PageObjets.ViewCartPage;
import autoExercise.Utilities.BaseClass;

/**
 * Test Case: Add product in cart.
 * Steps:
 * 1. Login by user
 * 2. Navigate to the Product page.
 * 3. Hover to the product and get product price.
 * 4. Add product
 * 5. click on view cart
 * 6. Get the product price on cart page.
 * 7. Compare the price.
 * 8. Removed product from cart to maintain clean state for next test run.
 */

public class TC5_AddProductsInCart extends BaseClass {

	@Test
	public void addProductsInCart() throws InterruptedException
	{
	    logger.info("Starting test: Add to Cart");

	    TC2_LoginUser login = new TC2_LoginUser();
	    login.verifyLoginUser();

	    HomePage homePage = new HomePage(driver);
	    homePage.products();

	    ProductsPage productsPage = new ProductsPage(driver);
	    productsPage.hoverToFirstProduct();
	    String ProductPrice = productsPage.getProductPrice();
	    logger.info("Captured product price from Products page: {}", ProductPrice);

	    productsPage.addFirstProduct();
	    logger.info("Added product to cart.");

	    productsPage.viewCart();
	    ViewCartPage viewCart = new ViewCartPage(driver);
	    logger.info("Opened View Cart page.");

	    String ProductPrice_InViewCart = viewCart.getProductPriceInViewCart();
	    String ProductQuantity = viewCart.getProductQuantity();
	    logger.info("View Cart Details -> Price: {} | Quantity: {}",ProductPrice_InViewCart, ProductQuantity);

	    if (ProductPrice.equalsIgnoreCase(ProductPrice_InViewCart) && ProductQuantity.equals("1")) {
	    	logger.info("Prosducts Has been added succesfully to the cart....");
	    } else {
	        viewCart.removeProduct();
	        logger.info("Product  quantity has not been added to the cart or quantity not matched.");
			logger.info("Removed product from cart to maintain clean state for next test run.");
	        Assert.fail("Failed! Product has not been added to the cart...");
	    }
        viewCart.removeProduct();
		logger.info("Removed product from cart to maintain clean state for next test run.");
		logger.info("Ending test: addProductsInCart");
	}
}
