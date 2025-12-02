package com.AutoExercise.PageObjets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsPage {

	WebDriver driver;
	
	JavascriptExecutor executor;
	Actions action;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		executor = (JavascriptExecutor)driver;
		action = new Actions(driver);
	}
	
	@FindBy(xpath = "//img[@src=\"/get_product_picture/1\"]")
	WebElement FirstProduct;
	
	@FindBy(xpath = "//a[text()=\"Add to cart\"]")
	WebElement AddToCart;
	
	@FindBy(xpath = "//img[@src=\"/get_product_picture/2\"]")
	WebElement SecondProduct;
	
	@FindBy(xpath = "(//a[text()=\"Add to cart\"])[2]")
	WebElement AddToCart2;
	
	@FindBy(xpath = "//button[text()=\"Continue Shopping\"]")
	WebElement ContinueShopping;
	
	@FindBy(xpath = "(//a[@href=\"/view_cart\"])[2]")
	WebElement ViewCart;
	
	@FindBy(xpath = "(//h2[text()=\"Rs. 500\"])[1]")
	WebElement ProductPrice;
	
	@FindBy(xpath = "//a[@href=\"/product_details/1\"]")
	WebElement ViewProduct;
	
	public void hoverToFirstProduct()
	{
		executor.executeScript("arguments[0].scrollIntoView();", SecondProduct);
		action.moveToElement(FirstProduct).perform();
	}
	
	public void addFirstProduct()
	{
		executor.executeScript("arguments[0].scrollIntoView();", FirstProduct);
		executor.executeScript("arguments[0].click();", AddToCart);
	}

	public void secondProduct()
	{
		action.moveToElement(SecondProduct).perform();
		executor.executeScript("arguments[0].click();", AddToCart2);
	}
	
	public void continueShopping()
	{
		ContinueShopping.click();
	}
	
	public void viewCart()
	{
		ViewCart.click();
	}
	
	public String getProductPrice()
	{
		return ProductPrice.getText();
	}
	
	public void viewProduct()
	{
		executor.executeScript("arguments[0].scrollIntoView();", FirstProduct);
		ViewProduct.click();
	}
}
