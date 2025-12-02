package com.AutoExercise.PageObjets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	WebDriver driver;
	JavascriptExecutor executor;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"name\"]")
	WebElement Name;
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement Email;
	
	@FindBy(xpath = "//input[@name=\"subject\"]")
	WebElement Subject;
	
	@FindBy(xpath = "//textarea[@name=\"message\"]")
	WebElement Message;
	
	@FindBy(xpath ="//input[@name=\"submit\"]")
	WebElement Submit;
	
	public void name(String NAME)
	{
		Name.sendKeys(NAME);
	}
	
	public void email(String EMAIL)
	{
		Email.sendKeys(EMAIL);
	}
	
	public void subject(String SUBJECT)
	{
		Subject.sendKeys(SUBJECT);
	}
	
	public void message(String MESSAGE)
	{
		Message.sendKeys(MESSAGE);
	}
	
	public void submit()
	{
		Submit.click();
	}
	
	@FindBy(xpath = "(//div[text()=\"Success! Your details have been submitted successfully.\"])[1]")
	WebElement SuccessMessage;
	
	public boolean isSuccessMessageDisplayed()
	{
		return SuccessMessage.isDisplayed();
	}
	
}
