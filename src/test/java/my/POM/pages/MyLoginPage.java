package my.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    By passwordFieldLocator = By.cssSelector("[type='password']");

    By submitButtonLocator = By.cssSelector("[type='submit']");

//    page methods

    public void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
    }

    public void provideEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
    }

    public void providePassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void login(){
        provideEmail("nishaabidi@yahoo.com");
        providePassword("Mylife#1234");
        clickSubmitBtn();
    }

}
