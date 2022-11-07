import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {


    @Test
    public void renamePlaylist() throws InterruptedException {
        // Step1: Log in with your credentials
        logIn();
        //  Double click on a playlist
        doubleClickChoosePlaylist();

        // Enter new playlist name
        enterPlaylistName();

        // assert that the new playlist name exist
       Assert.assertTrue(doesPlaylistExist());


    }

    private void enterPlaylistName() throws InterruptedException {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        Thread.sleep(3000);
        playlistInputField.sendKeys("Edited Playlist Name");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
        WebElement element = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(element).perform();
    }

    private boolean doesPlaylistExist() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Edited Playlist Name']"));


        return playlistElement.isDisplayed();

    }
}

    