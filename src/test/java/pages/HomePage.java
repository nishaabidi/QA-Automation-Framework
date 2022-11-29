package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement createPlaylistButton;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistOption;

    @FindBy(css = "[name='name']")
    WebElement playlistNameField;

//    @FindBy(css= "//*[@id='playlists']/ul/li/a/text()")
//    WebElement playlistName;

//
////    @FindBy(css = "#playlists > form > input[type=text]" )
//    @FindBy(css = "//*[@id='playlists']/form/input")
//    WebElement enteredName;

    @FindBys(
            @FindBy(css = "#playlists a[href*='playlist']")
    )
    List<WebElement> playlists;

    public HomePage(WebDriver sentDriver) {
        super(sentDriver);
    }

    public void createPlaylist(String name) throws InterruptedException {
        createPlaylistButton.click();
        newPlaylistOption.click();
        playlistNameField.sendKeys(name);
        playlistNameField.sendKeys(Keys.RETURN);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[name='name']")));
    }


    public String getDuplicatePlaylist(String name) throws InterruptedException {
        createPlaylistButton.click();
        newPlaylistOption.click();

        String msg = "";
        boolean dupFlag = isNameDuplicate(name); // This will return true or false
        System.out.println("dupFlag = " + dupFlag);
        if(!dupFlag){
            playlistNameField.sendKeys(name);
            playlistNameField.sendKeys(Keys.RETURN);
        }
        else {
            msg = "This playlist name already exists!";
            System.out.println(name + " already exists!");
        }
        return msg;
    }

    public boolean isNameDuplicate(String name){
        //System.out.println( "playlists.size() = " + playlists.size());
        boolean blnFound = false;
        for(int i=0; i < playlists.size(); i++){
            String currItem = playlists.get(i).getText();
            System.out.println(String.valueOf(i) + " >> [" + name + "] == [" + currItem +"]");
            if (currItem.equals(name)) {
                blnFound = true;
                break;
            }
        }
        return blnFound;
    }

    public int getNumberOfPlaylist() {
        return playlists.size();
    }
}