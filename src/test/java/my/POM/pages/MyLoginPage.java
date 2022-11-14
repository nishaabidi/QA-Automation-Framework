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
    By emailAddressField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");//2 elements are identified, lets add the button tag
//lets check it if it works, it should be type attribute, next lets try password and the submit/login button
//    next, lets try creating the enter email,password and submit methods


    //it now shows 1 usage since we used it in nisha_LoginTests class
      public void enterEmail(String email){
          driver.findElement(emailAddressField).sendKeys(email);
          //you can put your email here and remove the string email parameter
//          driver.findElement(emailAddressField).sendKeys("youremail");
      }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmitBtn(){
          driver.findElement(submitButton);
    }

//        I think we are done with the login methods, lets try running it in our test class
//            next, lets create our test class


}
