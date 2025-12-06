package autoExercise.PageObjets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;


public class SignUpPage {

	WebDriver driver;
	JavascriptExecutor executor;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor)driver;
	}
	

	@FindBy(xpath = "//input[@name=\"name\"]")
	WebElement Name;
	
	@FindBy(xpath = "(//input[@name=\"email\"])[2]")
	WebElement EmailAddress;
	
	@FindBy(xpath = "//button[text()=\"Signup\"]")
	WebElement SignUpButton;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//select[@id=\"days\"]")
	WebElement Day;
	
	@FindBy(xpath = "//select[@id=\"months\"]")
	WebElement Months;
	
	@FindBy(xpath = "//select[@id=\"years\"]")
	WebElement Years;	
	
	@FindBy(xpath = "//input[@id=\"first_name\"]")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@id=\"last_name\"]")
	WebElement LastName;
	
	@FindBy(xpath = "//input[@id=\"address1\"]")
	WebElement Address;
	
	@FindBy(xpath = "//input[@id=\"state\"]")
	WebElement State;
	
	@FindBy(xpath = "//input[@id=\"city\"]")
	WebElement City;
	
	@FindBy(xpath = "//input[@id=\"zipcode\"]")
	WebElement ZipCode;
	
	@FindBy(xpath = "//input[@id=\"mobile_number\"]")
	WebElement MobileNumber;
	
	@FindBy(xpath = "//button[text()=\"Create Account\"]")
	WebElement CreateAccount;
	
	@FindBy(xpath = "//input[@id=\"newsletter\"]")
	WebElement NewsLetterCheckbox;
	
	@FindBy(xpath = "//input[@id=\"optin\"]")
	WebElement SpecialOfferCheckbox;
	
	@FindBy(xpath = "//p[text()=\"Email Address already exist!\"]")
	WebElement EmailAlreadyExistMsg;
	
	@FindBy(xpath = "//b[text()=\"Account Created!\"]")
	WebElement AcoountCreatedSuccessMsg;
	
	public void dob(String DAY, String MONTH, String YEAR)
	{
		selectByValue(Day, DAY);
		selectByValue(Months, MONTH);
		selectByValue(Years, YEAR);
	}
	
	public void selectByValue(WebElement Dropdown, String Value)
	{
		Select select = new Select(Dropdown);
		select.selectByValue(Value);
	}
	
	public void password(String Pass)
	{
		password.sendKeys(Pass);
	}
	public void name(String name)
	{
		Name.sendKeys(name);
	}
	
	public String getName()
	{
		return Name.getAttribute("value");
	}
	
	public void emailAddress(String email)
	{
		EmailAddress.sendKeys(email);
	}
	
	public void signUpButton()
	{
		SignUpButton.click();
	}
	
	public void firstName(String FName)
	{
		FirstName.sendKeys(FName);
	}
	
	public void lastName(String LName)
	{
		LastName.sendKeys(LName);
	}
	
	public void address(String address)
	{
		Address.sendKeys(address);
	}
	
	public void state(String state)
	{
		State.sendKeys(state);
	}
	
	public void city(String city)
	{
		City.sendKeys(city);
	}
	public void zipCode(String zipcode)
	{
		ZipCode.sendKeys(zipcode);
	}
	
	public void mobileNumber(Faker faker)
	{
		String RandomDigits = faker.number().digits(10);
		char FirstDigit = faker.options().option('9', '8', '7');
		String Number = FirstDigit + RandomDigits;
		MobileNumber.sendKeys(Number);
	}
	
	public void createAccount()
	{
		executor.executeScript("arguments[0].click();", CreateAccount);
	}
	
	public void newsLetterCheckbox()
	{
		executor.executeScript("arguments[0].click();", NewsLetterCheckbox);
		//NewsLetterCheckbox.click();
	}
	
	public void specialOfferCheckbox()
	{
		executor.executeScript("arguments[0].click();", SpecialOfferCheckbox);
	//	SpecialOfferCheckbox.click();
	}
	
	public boolean isEmailAlreadyExistMsgDisplayed()
	{
		return EmailAlreadyExistMsg.isDisplayed();
	}
	
	public boolean isAccountCreateMsgDisplayed()
	{
		return AcoountCreatedSuccessMsg.isDisplayed();
	}
}
