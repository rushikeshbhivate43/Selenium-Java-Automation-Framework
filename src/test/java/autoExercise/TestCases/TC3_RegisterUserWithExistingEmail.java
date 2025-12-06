package autoExercise.TestCases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.SignUpPage;
import autoExercise.Utilities.BaseClass;

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
