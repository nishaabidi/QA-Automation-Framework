import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.net.URL;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    Actions actions;

    String url;

    ThreadLocal<WebDriver> threadDriver;



    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeSuite
    public static void geckoConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        }
    }



    @BeforeMethod
    @Parameters({"baseURL"})
    // we have used parameterization here but we havent declared it in our TestNG xml file.
    // lets try adding it to our TestNG xml file..
    // now our launchbrowser method can now access baseurl parameter in TestNG xml file
    // lets try running it
    public void launchBrowser(String baseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

         actions = new Actions(getDriver());
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        getDriver().get(baseURL);


    }

        public WebDriver getDriver(){
        return threadDriver.get();
        }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        String gridURL = "http://192.168.1.228:4444";
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "grid-edge":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lamdaTest();
            default:
                return driver = new ChromeDriver();
        }
    }

    public WebDriver lamdaTest() throws MalformedURLException{
        String username = "nishaabidi";
        String accessKey = "WKntZEjDnDgQSeogLN4uXNGFFTdaffbF09IyDqk9Vp6ilBrRI0";
        String hub = "@hub.lamdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "107.0");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("build", "First Test");
        capabilities.setCapability("name", this.getClass().getName());
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        capabilities.setCapability("plugin","git-testing");
        return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);

    }

//    private WebDriver pickBrowser(String browser) throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        String gridURL = "http://192.168.1.228:4444";
//        switch (browser){
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//                return driver = new FirefoxDriver();
//            case "MicrosoftEdge":
//                System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
//                return driver = new EdgeDriver();
//            case "grid-edge":
//                caps.setCapability("browserName", "MicrosoftEdge");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
//            case "grid-firefox":
//                caps.setCapability("browserName", "firefox");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
//            case "grid-chrome":
//                caps.setCapability("browserName", "chrome");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
//            default:
//                return driver = new ChromeDriver();
//        }
//    }


    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public void clickSubmitBtn() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    @DataProvider(name="invalidCredentials")
    public static Object[][] getCredentials(){

        return new Object[][] {
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }
    public void logIn(){
        provideEmail("nishaabidi@yahoo.com");
        providePassword("Mylife#1234");
        clickSubmitBtn();
    }
}
