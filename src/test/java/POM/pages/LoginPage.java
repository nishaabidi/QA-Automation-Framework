package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

//     declaring driver
//    WebDriver driver;
//    WebDriverWait wait;

//     declaring the locators
    By emailFieldLocator = By.cssSelector("[type='email']");
    @FindBy (css= "[type='email']")
            WebElement emailField;
    By passwordFieldLocator = By.cssSelector("[type='password']");
    @FindBy (css= "[type='password']")
    WebElement passwordField;
    By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy (css= "[type='submit']")
    WebElement submitButton;

// passing the driver from our LoginTests page(attributes)
    public LoginPage(WebDriver givenDriver ){
        super(givenDriver);
    }

//    page methods

    public LoginPage clickSubmitBtn(){
        submitButton.click();
        return this;
    }

    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage login(){
        provideEmail("nishaabidi@yahoo.com")
                .providePassword("Mylife#1234")
                        .clickSubmitBtn();
        return new HomePage(driver);
    }
}
