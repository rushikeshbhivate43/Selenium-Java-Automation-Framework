package autoExercise.TestCases;

import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.SignUpPage;
import autoExercise.Utilities.BaseClass;

/**
 * Test Case: Verify user can SignUp.
 * Steps:
 * 1. Navigate to signUP page.
 * 2. Enter valid name and email and click on submit.
 * 3. Extract first and last name.
 * 4. Fill account details.
 * 5. Submit the form
 * 6. Verify account created message is displayed
 */
public class TC1_RegisterUser extends BaseClass{

	Faker faker = new Faker(new Locale("en-IND"));
	@Test
	public void verifyUserCanSignUp()
	{
		HomePage home = new HomePage(getDriver());
		home.signUp();

		SignUpPage signUp = new SignUpPage(getDriver());
		signUp.name(faker.name().firstName() +" " + faker.name().lastName());
		String FullName = signUp.getName();
		signUp.emailAddress(FullName.replaceAll(" ", "") + "@gmail.com"); 
		signUp.signUpButton();

		String[] nameParts = FullName.split(" ");
		String firstName = nameParts[0];
		String lastName = nameParts[1];   

		signUp.password(firstName + "@1234"); 
		signUp.dob("28", "3", "1998"); 
		signUp.newsLetterCheckbox();
		signUp.specialOfferCheckbox();
		signUp.firstName(firstName);
		signUp.lastName(lastName);

		String address = "Karve Nagar";
		signUp.address(address);
		String State  = "Maharashtra";
		signUp.state(State);
		String City = "Pune";
		signUp.city(City);
		String ZipCode = "411023";
		signUp.zipCode(ZipCode);
		signUp.mobileNumber(faker);
		
		String UserAddress = address + State + City + ZipCode;
		signUp.createAccount();

		boolean isAccountCreated = signUp.isAccountCreateMsgDisplayed();
		Assert.assertTrue(isAccountCreated, "User registration failed!");
		logger.info("Account created successfully for user: " + FullName);

	}

}
