package com.AutoExercise.PageObjets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	JavascriptExecutor executor;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "(//input[@name=\"email\"])[1]")
	WebElement EmailAddress;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()=\"Login\"]")
	WebElement Login;
	
	public void emailAddress(String email)
	{
		EmailAddress.sendKeys(email);
	}
	
	public void Password(String Pass)
	{
		Password.sendKeys(Pass);
	}
	
	public void login()
	{
		Login.click();
	}
}
