package com.AutoExercise.PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsDetailsPage {

	WebDriver driver;
	
	public ProductsDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id=\"quantity\"]")
	WebElement Quantity;
	
	@FindBy(xpath = "//button[@type=\"button\"]")
	WebElement AddToCart;
	
	public void quantity(String quantity)
	{
		Quantity.clear();
		Quantity.sendKeys(quantity);
	}
	
	public void addToCart()
	{
		AddToCart.click();
	}
}
