package autoExercise.PageObjets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ViewCartPage {

	WebDriver driver;
	
	JavascriptExecutor executor;
	
	public ViewCartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[3]")
	WebElement ProductPrice_InViewCart;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[4]")
	WebElement ProductQuantity;
	
	@FindBy(xpath = "//a[@class=\"cart_quantity_delete\"]")
	WebElement RemoveProduct;
	
	public String getProductPriceInViewCart()
	{
		return ProductPrice_InViewCart.getText();
	}
	
	public String getProductQuantity()
	{
		return ProductQuantity.getText();
	}
	
	public void removeProduct() throws InterruptedException
	{
		Thread.sleep(2000);
		RemoveProduct.click();
		//executor.executeScript("arguments[0].click();", RemoveProduct);
	}
}
