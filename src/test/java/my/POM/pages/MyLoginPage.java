package my.POM.pages;

import POM.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyLoginPage extends MyBasePage {


//    now for login page lets create another constructor for it for our driver instance, lets extend it to base page
//    first, there our constructor is auto generated
    public MyLoginPage(WebDriver givenDriver) {
    super(givenDriver);
}
//    next, lets store the web elements and create methods in our Login Page, lets check it
//so this is our login page
//lets list the possible methods in our login page
//    1.) enter email
//        2.) enter password
//    3.) click login/submit button
//    4.) click registration link
//    now that we have listed some possible methods for our login page, lets create our methods
//    lets first declare our locators, by declaring them using "By" selector

    //     declaring the locators
    By emailFieldLocator = By.cssSelector("[type='email']");
    @FindBy(css= "[type='email']")
    WebElement emailField;
    By passwordFieldLocator = By.cssSelector("[type='password']");
    @FindBy (css= "[type='password']")
    WebElement passwordField;
    By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy (css= "[type='submit']")
    WebElement submitButton;
//    page methods

    public MyLoginPage clickSubmitBtn(){
        submitButton.click();
        return this;
    }

    public MyLoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public MyLoginPage providePassword(String password){
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
