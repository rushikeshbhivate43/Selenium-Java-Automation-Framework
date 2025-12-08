package autoExercise.TestCases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.LoginPage;
import autoExercise.Utilities.BaseClass;

/**
 * Test Case: Verify that a registered user can log in successfully.
 * Steps:
 * 1. Navigate to login page
 * 2. Enter valid credentials
 * 3. Verify login by checking 'Delete Account' button
 */
public class TC2_LoginUser extends BaseClass{

	@Test
	public void verifyLoginUser() {
		logger.info("Starting test: verifyLoginUser");

		HomePage homepage = new HomePage(driver);
		homepage.signUp();
		logger.info("Navigated to Sign Up / Login page");

		LoginPage login = new LoginPage(driver);
		login.emailAddress("rushikeshbhivate43@gmail.com");
		login.Password("Rushikesh@1234");
		login.login();
		logger.info("Entered credentials and clicked login");

		try {
			Assert.assertTrue(homepage.isDeleteAccountDisplayed(),
					"Login Failed - Delete Account button not visible");
			logger.info("Login Successful - Delete Account button displayed");
			
		} catch (NoSuchElementException e) {
			logger.error("Exception occurred while validating login", e);
			Assert.fail("Login Failed - Delete Account button not visible");
		}

		logger.info("Ending test: verifyLoginUser");
	}
}