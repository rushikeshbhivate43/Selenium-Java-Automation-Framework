package autoExercise.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.Utilities.BaseClass;

/**
 * Test Case: Verify subscription.
 * Steps:
 * 1. Login by user
 * 2. Scroll to the bottom of the page.
 * 3. Enter email and click the subsribed  button.
 * 4. Verify the success msg is displayed.
 */

public class TC8_VerifySubscription extends BaseClass {

	@Test
	public void verifySubscription()
	{
		TC2_LoginUser login = new TC2_LoginUser();
		login.verifyLoginUser();
		
		logger.info("Starting test: verify subscription");
		HomePage homePage = new HomePage(driver);
		homePage.subscribeEmail("rushikeshbhivate43@gmail.com");
		homePage.subscribeButton();
		homePage.verifySubscriptionSuccessMsg();

		Assert.assertTrue(homePage.verifySubscriptionSuccessMsg(), "Success message not displayed!");
	    logger.info("Ending Test: verify subscription");
	}
}
