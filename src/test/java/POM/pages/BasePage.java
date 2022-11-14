package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

//    locators
    private final By allSongMenuItemLocator = By.cssSelector("li a.songs");

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void clickOnAllSongs(){
        driver.findElement(allSongMenuItemLocator).click();
    }

    //this method performs a double click and accepts a WebElement parameter
    public void doubleClick(WebElement locator){
        //lets also add an explicit wait
        wait.until(ExpectedConditions.visibilityOf(locator));
        // wait for element to be clickable
        actions.doubleClick(locator).perform();
        //then performs a double click using Actions class
    }

    //this method performs a right click and accepts a WebElement parameter
    public void rightClick(WebElement locator){
        //lets also add an explicit wait
        wait.until(ExpectedConditions.visibilityOf(locator));
        // wait for element to be clickable
        actions.contextClick(locator);
        //then performs a right click using Actions class
    }
    public void refreshCurrentPage(){
        driver.navigate().refresh();
        //this refreshes the current browser page
    }


}
