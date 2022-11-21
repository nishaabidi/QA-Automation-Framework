package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {

    By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
    //    By firstSongLocator = By.cssSelector("tr.song-item");
    By firstSongLocator = By.cssSelector(".all-songs tr.song-item:nth-child(1)");

    By playOption = By.cssSelector("ul:nth-child(1) > li.playback");

    By soundBarElement = By.cssSelector("div.bars img");

    @FindBy(css = "#songsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title")
    WebElement firstSongElement;
    //this is for page factory, lets use it in the future, not for now


    //lets review our first song locator.
    // lets try to change our locator since it is identifying multiple elements
    //lets try to use this css locator
    //i think we used a wrong locator at first.
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public AllSongsPage shuffle() {

        driver.findElement(shuffleBtnLocator).click();
        return this;
    }

    public void doubleClickFirstSong() {
//        since we have the doubleclick method in the BasePage, we can use it here
        WebElement firstSongElement = driver.findElement(firstSongLocator);
//        we need to declare it as a web element since it is the parameter accepted by our doubleclick method in basepage
        doubleClick(firstSongElement);
    }

    public void rightClickFirstSong() {
        WebElement firstSongElement = driver.findElement(firstSongLocator);
        rightClick(firstSongElement);
    }

    public void choosePlayOption(){
        WebElement firstSongElement = driver.findElement(playOption);
        click(firstSongElement);
    }

//    when we want to use a method that returns a boolean value (true or false),
//        we can name it like this for readability

    public boolean isSoundBarDisplayed(){
        WebElement soundBarIcon = driver.findElement(soundBarElement);
        return soundBarIcon.isDisplayed();
        //this will return true if sound bar element is displayed
    }



//    public void contextClickFirstSong(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper > div > div > div.item-container > table > tr.song-item.playing.selected > td.title")));
//        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs"));
//        actions.contextClick(firstSong).perform();
//    }


//    public void rightClick() {
//        rightClick(firstSongElement);
//    }

    public void playFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.li.playback.span")));
    }

}
