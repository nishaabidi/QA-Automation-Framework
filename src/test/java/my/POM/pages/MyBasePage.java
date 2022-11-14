package my.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyBasePage {

    public WebDriver driver;

    public WebDriverWait wait;

    public Actions actions;

//    now we declare our webdriver, webdriver wait, and our actions class here,
// so we dont have to declare it in every page, since we will inherit this page later by using "extends"

//    next lets create a mybasepage constructor so that we could have a driver instance from our
//    mybasetest class
//
//    we can use the right click + generate feature of intelliJ to create a constructor

    //we named it given driver since this is the driver instance from basetest class(for readability)
    //then lets declare our wait and action class
    //we declared 10 seconds for webdriver wait, it will wait 10 seconds for an element before throwing an exception
    public MyBasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    //in our base page, we put all our generic methods which can be used in all of our pages
//    unlike login page, where we store the enteremail method since it is only used in our login page
//    since mybasepage is for generic methods, we can add a generic method here, lets try to add
//            the double click method, which we can use in all of our pages


//    lets also add another method, for single click, this method will help us, since we dont have to
//    declare the webdriver wait everytime
    public void click(WebElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
        locator.click();
    }

    //    in this method, it will accept a web element as its parameter, then it will perform double click
//        then we will use the action class double click method..
    public void doubleClick(WebElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
        actions.doubleClick(locator);
    }

}
