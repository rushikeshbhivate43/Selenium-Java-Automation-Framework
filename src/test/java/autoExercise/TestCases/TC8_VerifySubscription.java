package autoExercise.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.Utilities.BaseClass;

public class TC8_VerifySubscription extends BaseClass {

	@Test
	public void verifySubscription()
	{
		TC2_LoginUser login = new TC2_LoginUser();
		login.verifyLoginUser();
		
		logger.info("Starting test: verify subscription");
		HomePage homePage = new HomePage(driver);
		homePage.subscribeEmail("AatreyaSharma@gmail.com");
		homePage.subscribeButton();
		homePage.verifySubscriptionSuccessMsg();

		Assert.assertTrue(homePage.verifySubscriptionSuccessMsg(), "Success message not displayed!");
	    logger.info("Ending Test: verify subscription");
	}
}
