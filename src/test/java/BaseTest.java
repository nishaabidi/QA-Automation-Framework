import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    String url;

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterMethod
    public void teadDownBrowser() {
        driver.quit();
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
