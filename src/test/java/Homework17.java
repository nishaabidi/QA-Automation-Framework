import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist(){
        //login
        provideEmail("nishaabidi@yahoo.com");
        providePassword();
        clickSubmitBtn();

        //Add new song to the playlist
        addNewSong();

    }

    private void addNewSong(){
       getAllSongs();

       selectASong();

       addASong();

       addToPlaylist();

       getPlaylistLink();

        // Verify that the song was added to the HW17 Playlist
        verifySongAddedToPlaylist();
    }



    private void getAllSongs() {
        WebElement allSongs = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongs.click();
    }

    private void selectASong() {
        WebElement selectASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[12]/td[2]"));
        selectASong.click();
    }

    private void addASong() {
        WebElement addSongBtn = driver.findElement(By.xpath("//button[contains(@title,'Add selected songs to')]"));
        addSongBtn.click();
    }

    private void addToPlaylist() {
        WebElement addToPlaylistHW17 = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[contains(text(),'HW17')]"));
        addToPlaylistHW17.click();
    }

    private void getPlaylistLink() {
        WebElement playlistHW17Link = driver.findElement(By.xpath("//a[text()='HW17']"));
        playlistHW17Link.click();
        driver.navigate().refresh();
    }

    private void verifySongAddedToPlaylist() {
        WebElement addedSongToPlaylistHW17 = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr//td[text()=\"Reactor\"]"));
        Assert.assertTrue(addedSongToPlaylistHW17.isDisplayed());
    }


}






