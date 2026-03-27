package autoExercise.Utilities;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    String url = readConfig.getBaseUrl();

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Logger logger;

    public WebDriver getDriver() {
        return driver.get();
    }

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("edge") String browser) {

        System.out.println("===== Driver setup started =====");
        System.out.println("Running on browser: " + browser);

        switch (browser.toUpperCase()) {

        case "CHROME":
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(option));
            break;

        case "FIREFOX":
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
            break;

        case "EDGE":
        	System.setProperty("webdriver.edge.driver", "C:\\Eclipse Workspace\\Driver\\msedgedriver.exe");            
        	driver.set(new EdgeDriver());
            break;
        
        default:
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().manage().window().maximize();

        logger = LogManager.getLogger("ERP");

        getDriver().get(url);

        logger.info("URL Opened: " + url);
    }

  @AfterClass
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }

        logger.info("Browser Closed");
    }
 
}