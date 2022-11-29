package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css="[type='email']")
    WebElement emailField;

    @FindBy(css="[type='password']")
    WebElement passwordField;

    @FindBy(css="[type='submit']")
    WebElement submitButton;

    @FindBy(css="[data-testid='login-form']")
    WebElement loginForm;

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public HomePage submit() throws InterruptedException {
        submitButton.click();
        Thread.sleep(1000); // to generate the video
        return new HomePage(driver);
    }

    public LoginPage enterEmail(String email) throws InterruptedException {
        emailField.sendKeys(email);
        Thread.sleep(1000); // to generate the video
        return this;
    }

    public LoginPage enterPassword(String password) throws InterruptedException {
        passwordField.sendKeys(password);
        Thread.sleep(1000); // to generate the video
        return this;
    }

    public HomePage login() throws InterruptedException {
        enterEmail("nishaabidi@yahoo.com");
        enterPassword("Mylife#1234");
        return submit();
    }

    public boolean isErrorShown() {
        return loginForm.getAttribute("class").equals("error");
    }
}