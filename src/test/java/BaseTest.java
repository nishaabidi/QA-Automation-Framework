import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

import static java.lang.System.*;

public class BaseTest {

    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;

    static String where;
    static String browser;
    static String env;
    static String suite;
    static String parameters;

    @BeforeSuite
    public static void chromeConfig() {
        // This is for Windows users
        if (getProperty("os.name").toLowerCase().contains("win")) {
            setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            setProperty("webdriver.chrome.driver", "Untitled/chromedriver");
        }
        where = getProperty("where") != null ? getProperty("where") : "local";
        browser = getProperty("env") != null ? getProperty("env") : "qa";
        browser = getProperty("browser") != null ? getProperty("browser") : "chrome";
        suite = getProperty("suite") != null ? getProperty("suite") : "smoke";
        parameters = where + " " + browser + " " + env + " " + suite;
        // Just checking
        out.println(parameters);
    }

    private WebDriver getDriver() throws MalformedURLException {
        if(where.contains("selenoid")) {
            return configRemoteWebDriver();
        }
        else if (where.contains("lambdatest")){
            return configLambdaTestDriver();
        }
        if(browser.contains("safari")){
            return new SafariDriver();
        }
        else if(browser.contains("firefox")){
            return new FirefoxDriver();
        }
        else return new ChromeDriver();
    }

    private WebDriver configLambdaTestDriver() throws MalformedURLException {
        String username = getenv("LT_USERNAME") == null ? "dancefront" : getenv("LT_USERNAME");
        String authkey = getenv("LT_ACCESS_KEY") == null ? "Q3kapiUPNjt4PRRUTA4Hx6SEK523Lpi5vGF148aniE6qcdxcwx" : getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        // Configure your capabilities here
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "91.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    private WebDriver configRemoteWebDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "106.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", false,
                "enableVideo", false
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://13.59.76.15:4444/wd/hub").toURL(),
                capabilities);
        return driver;
    }

    private String getUrl(){
        if (env != null) {
            if (env.contains("dev")) {
                return "https://dev.koel.app";
            } else if (env.contains("stage")) {
                return "https://stage.koel.app";
            } else if (env.contains("prod")) {
                return "https://koel.app";
            }
        }
        return "https://bbb.testpro.io";
    }

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {
        url = getUrl();
        driver = getDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
}