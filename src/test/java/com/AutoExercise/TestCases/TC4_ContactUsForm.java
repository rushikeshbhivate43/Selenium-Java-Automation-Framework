package com.AutoExercise.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.AutoExercise.PageObjets.ContactUsPage;
import com.AutoExercise.PageObjets.HomePage;
import com.AutoExercise.Utilities.BaseClass;

public class TC4_ContactUsForm extends BaseClass {

	@Test
	public void contactUsForm()
	{
		TC2_LoginUser login = new TC2_LoginUser();
		login.verifyLoginUser();
		
		HomePage homePage = new HomePage(driver);
		homePage.contactUs();
		
		ContactUsPage contactUs = new ContactUsPage(driver);
		contactUs.name("Aatreya Sharma");
		contactUs.email("AatreyaSharma@gmail.com");
		contactUs.subject("Test Subject 123");
		contactUs.message("This is a dummy message for automation script testing purposes. Please ignore.");
		contactUs.submit();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		try {
			contactUs.isSuccessMessageDisplayed();
			logger.info("Success! Your details have been submitted successfully.");
		} catch (NoSuchElementException e) {
			Assert.fail("Failed! Your details have not been submitted.");
		}
		
	}
}
