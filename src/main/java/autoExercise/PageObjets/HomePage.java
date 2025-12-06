package autoExercise.PageObjets;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	JavascriptExecutor executor;
	
	Logger logger = LogManager.getLogger(HomePage.class);
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
	
	@FindBy(xpath = "//input[@id=\"susbscribe_email\"]")
	WebElement SubscribeEmail;
	
	@FindBy(xpath = "//button[@id=\"subscribe\"]")
	WebElement SubscribeButton;
	
	private By SubscriptionSuccesMsg = By.xpath("//div[@class=\"alert-success alert\"]");
	
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
	
	public void subscribeEmail(String email)
	{
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		SubscribeEmail.sendKeys(email);
	}
	
	public void subscribeButton()
	{
		SubscribeButton.click();
	}
	
	public boolean verifySubscriptionSuccessMsg()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	        wait.pollingEvery(Duration.ofMillis(50));

	        try {
	            logger.info("Waiting for success message to appear...");

	            WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(SubscriptionSuccesMsg));

	            logger.info("Success message found: " + msg.getText());

	            return msg.getText().contains("You have been successfully subscribed!");

	        } catch (Exception e) {

	            logger.error("Successfully subscribed message NOT found (maybe disappeared too fast)", e);
	            return false;
	        }
	       
	}
}
