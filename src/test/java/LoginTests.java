import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void LoginTest() throws InterruptedException {
        HomePage homePage = new LoginPage(driver)
                .enterEmail("demo@class.com")
                .enterPassword("te$t$tudent")
                .submit();
        Assert.assertTrue(homePage.isLoggedIn());

//        Just checking :)))
//        Assert.assertEquals(driver.getCurrentUrl(), "Fail please, so we see the properties: " + parameters);
    }

    @Test
    public void LoginInvalidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .enterEmail("demo@class.com")
                .enterPassword("incorrectpassword")
                .submit();
        Assert.assertTrue(loginPage.isErrorShown(), "No error shown on Login page");

//        Just checking :)
//        Assert.assertEquals(driver.getCurrentUrl(), "Fail please, so we see the properties: " + parameters);
    }
}