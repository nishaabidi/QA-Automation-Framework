package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
//    By firstSongLocator = By.cssSelector("tr.song-item");
    By firstSongLocator = By.cssSelector(".all-songs tr.song-item:nth-child(1)");

    //lets review our first song locator.
    // lets try to change our locator since it is identifying multiple elements
    //lets try to use this css locator
    //i think we used a wrong locator at first.
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void shuffle(){
    driver.findElement(shuffleBtnLocator).click();
    }

    public void doubleClickFirstSong() {
//        since we have the doubleclick method in the BasePage, we can use it here
        WebElement firstSongElement = driver.findElement(firstSongLocator);
//        we need to declare it as a web element since it is the parameter accepted by our doubleclick method in basepage
        doubleClick(firstSongElement);
    }
}
