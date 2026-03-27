package autoExercise.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import autoExercise.PageObjets.HomePage;
import autoExercise.PageObjets.SignUpPage;
import autoExercise.Utilities.BaseClass;
import autoExercise.Utilities.ExcelUtils;

public class TC10_SignUpUsingExcelData extends BaseClass{
	
	@DataProvider(name = "registerData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getData("C:\\Eclipse Workspace\\MyJavaProject\\AutomationExerciseFramework\\UsersData\\UsersDataForSignUp.xlsx", "RegisterUser");
    }

    @Test(dataProvider = "registerData")
    public void signUpUserUsingExcelData(String firstName, String lastName, String email,
                                    String password, String address, String state,
                                    String city, String zip) {

        HomePage home = new HomePage(getDriver());
        home.signUp();

        SignUpPage signUp = new SignUpPage(getDriver());

        // Full Name
        String fullName = firstName + " " + lastName;
        signUp.name(fullName);
        signUp.emailAddress(email);
        signUp.signUpButton();

        // Fill remaining details
        signUp.password(password);
        signUp.dob("28", "3", "1998");
        signUp.newsLetterCheckbox();
        signUp.specialOfferCheckbox();

        signUp.firstName(firstName);
        signUp.lastName(lastName);
        signUp.address(address);
        signUp.state(state);
        signUp.city(city);
        signUp.zipCode(zip);

        signUp.mobileNumber(new com.github.javafaker.Faker());

        signUp.createAccount();

        boolean isAccountCreated = signUp.isAccountCreateMsgDisplayed();
        Assert.assertTrue(isAccountCreated, "User registration failed!");

        logger.info("Account created successfully for user: " + fullName);
        home.clickContinue();
        home.logOut();
    }
}