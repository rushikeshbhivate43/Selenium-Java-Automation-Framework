package autoExercise.PageObjets;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsDetailsPage {

	WebDriver driver;
	Logger logger = LogManager.getLogger(ProductsDetailsPage.class);


	public ProductsDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"quantity\"]")
	private WebElement Quantity;

	@FindBy(xpath = "//button[@type=\"button\"]")
	private WebElement AddToCart;

	@FindBy(xpath = "//input[@id=\"name\"]")
	private WebElement Name;

	@FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement Email;

	@FindBy(xpath = "//textarea[@name=\"review\"]")
	private WebElement AddReviewHere;

	@FindBy(xpath = "//button[@id=\"button-review\"]")
	private WebElement Submit;

	private By SuccessMsg = By.xpath("//div[contains(@class,'alert-success')]/span");


	public void quantity(String quantity)
	{
		Quantity.clear();
		Quantity.sendKeys(quantity);
	}

	public void addToCart()
	{
		AddToCart.click();
	}

	public void name(String name)
	{
		Name.sendKeys(name);
	}

	public void email(String email)
	{
		Email.sendKeys(email);
	}

	public void addReviewHere(String review)
	{
		AddReviewHere.sendKeys(review);
	}

	public void submit()
	{
		Submit.click();;
	}


    public boolean verifySuccessMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.pollingEvery(Duration.ofMillis(50));

        try {
            logger.info("Waiting for success message to appear...");

            WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(SuccessMsg));

            logger.info("Success message found: " + msg.getText());

            return msg.getText().contains("Thank you for your review.");

        } catch (Exception e) {

            logger.error("Success review message NOT found (maybe disappeared too fast)", e);
            return false;
        }
    }
}
