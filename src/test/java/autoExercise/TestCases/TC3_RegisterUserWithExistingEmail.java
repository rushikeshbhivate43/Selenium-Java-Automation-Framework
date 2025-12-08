package autoExercise.TestCases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.SignUpPage;
import autoExercise.Utilities.BaseClass;

/**
 * Test Case: Verify Register User is Already Exist.
 * Steps:
 * 1. Navigate to signUP page.
 * 2. Enter valid name and email
 * 3. Click on SignUp button.
 * 4. Verify Emial by checking 'Email adress is already exist' msg.
 */
public class TC3_RegisterUserWithExistingEmail extends BaseClass {

	@Test
	public void verifyRegisterUserIsAlreadyExist()
	{
		HomePage homePage = new HomePage(driver);
		homePage.signUp();
		
		SignUpPage signUP = new SignUpPage(driver);
		signUP.name("Chaitan Ahuja");

		signUP.emailAddress("ChaitanAhuja@gmail.com");
		signUP.signUpButton();
		
		try {
	      signUP.isEmailAlreadyExistMsgDisplayed();
	        System.out.println("Email Address is already exist");
	    } catch (NoSuchElementException e) {
	        Assert.fail("Email is not exist");
	    }
	}
}
