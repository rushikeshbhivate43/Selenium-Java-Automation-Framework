package autoExercise.PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//li[@class=\"address_firstname address_lastname\"])[1]")
	WebElement Address_FirstName;
	
	@FindBy(xpath = "(//li[@class=\"address_address1 address_address2\"])[1]")
	WebElement Address;
	
	@FindBy(xpath = "(//li[@class=\"address_city address_state_name address_postcode\"])[1]")
	WebElement Address_City;
	
	@FindBy(xpath = "(//li[@class=\"address_country_name\"])[1]")
	WebElement Address_Country;
		
	public String getAddressFirstName()
	{
		return Address_FirstName.getText();
	}
	public String getAddress()
	{
		return Address.getText();
	}
}
