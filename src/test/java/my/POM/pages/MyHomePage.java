package my.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyHomePage extends MyBasePage {
//    WebDriver driver;
//    WebDriverWait wait;

//    Locators
    By avatarLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
    By soundBarPlayLocator = By.cssSelector("[data-testid = 'sound-bar-play']");
    //it cant find this element
    public MyHomePage(WebDriver sentDriver) {
        super (sentDriver) ;
    }

    public WebElement getUserAvatar(){
        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public boolean isSongPlaying() {
        //lets try and add an explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarPlayLocator));
        WebElement soundBarVisualizer = driver.findElement(soundBarPlayLocator );
        return soundBarVisualizer.isDisplayed();
    }
}
