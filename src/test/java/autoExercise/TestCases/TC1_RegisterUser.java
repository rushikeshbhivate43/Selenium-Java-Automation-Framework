package autoExercise.TestCases;

import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.SignUpPage;
import autoExercise.Utilities.BaseClass;

public class TC1_RegisterUser extends BaseClass{

	Faker faker = new Faker(new Locale("en-IND"));
	@Test
	public void verifyUserCanSignUp()
	{
		// Step 1: Navigate to Sign Up page
		HomePage home = new HomePage(driver);
		home.signUp();
		
        // Step 2: Fill basic details - Name & Email
		SignUpPage signUp = new SignUpPage(driver);
		signUp.name(faker.name().firstName() +" " + faker.name().lastName());
		String FullName = signUp.getName();
		signUp.emailAddress(FullName.replaceAll(" ", "") + "@gmail.com"); 
		signUp.signUpButton();
 		
        // Step 3: Extract first and last name
		String[] nameParts = FullName.split(" ");
		String firstName = nameParts[0];
		String lastName = nameParts[1];  
		
        // Step 4: Fill account details
		signUp.password(firstName + "@1234"); 
		signUp.dob("28", "3", "1998");
		signUp.newsLetterCheckbox();
		signUp.specialOfferCheckbox();
		signUp.firstName(firstName);
		signUp.lastName(lastName);
		
		signUp.address("Karve Nagar");
		signUp.state("Maharashtra");
		signUp.city("Pune");
		signUp.zipCode("411023");
		signUp.mobileNumber(faker);
        // Step 6: Submit account creation form

		signUp.createAccount();
		
        // Step 7: Validation - Verify account created message is displayed

		 boolean isAccountCreated = signUp.isAccountCreateMsgDisplayed();
	        Assert.assertTrue(isAccountCreated, "User registration failed!");
	        logger.info("Account created successfully for user: " + FullName);
	        
		/*try {
			signUp.isAccountCreateMsgDisplayed();
			System.out.println("Account created succesfully....");
		} catch (NoSuchElementException e) {
			Assert.fail("User registration is failed...");
		}*/
	}
	
}
