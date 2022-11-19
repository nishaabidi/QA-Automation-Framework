package my.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyBasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

//    locators
    private final By allSongMenuItemLocator = By.cssSelector("li a.songs");

    public MyBasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void clickOnAllSongs(){
        driver.findElement(allSongMenuItemLocator).click();
    }

    //this method performs a  click and accepts a WebElement parameter (this is the selenium click command with webdriver wait)
    public void click(WebElement locator){
        //lets also add an explicit wait
        wait.until(ExpectedConditions.visibilityOf(locator));
        // wait for element to be clickable
        locator.click();
        //then performs a double click using Actions class
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
    public void rightClick (WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(locator).perform();
    }


    //this method performs a right click and accepts a WebElement parameter

//    public void rightClick() {
//        //lets also add an explicit wait
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(#songsWrapper>div>div>div.item-container > table > tr:nth-child(1) > td.title)));
//        // wait for element to be clickable
//        WebElement firstSongElement = driver.findElement(firstSongLocator);
//        actions.contextClick(firstSongElement).perform();
//        //then performs a right click using Actions class
//    }


    public void refreshCurrentPage(){
        driver.navigate().refresh();
        //this refreshes the current browser page
    }



}
