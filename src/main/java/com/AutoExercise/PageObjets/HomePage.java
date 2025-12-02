package com.AutoExercise.PageObjets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	JavascriptExecutor executor;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "//a[@href=\"/login\"]")
	WebElement SignUp;
	
	@FindBy(xpath = "//a[@href=\"/delete_account\"]")
	WebElement DeleteAccount;
	
	@FindBy(xpath = "//a[@href=\"/contact_us\"]")
	WebElement ContactUs;
	
	@FindBy(xpath = "//a[@href=\"/products\"]")
	WebElement Products;
	
	public void signUp()
	{
		SignUp.click();
	}
	
	public boolean isDeleteAccountDisplayed()
	{
		return DeleteAccount.isDisplayed();
	}
	
	public void contactUs()
	{
		ContactUs.click();
	}
	
	public void products()
	{
		Products.click();
	}
}
