import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {


    @Test
    public void deletePlaylist() throws InterruptedException {
        // Step1: Log in with your credentials
        logIn();
        // Step2: Choose a playlist
        selectPlaylist();
        // Step3: Delete the playlist
        pressDeletePlaylist();
        // Step4: Validate that the playlist is deleted "Deleted playlist"
        Assert.assertEquals(getConfirmationPopupText(), "Deleted playlist \"HW20.\"");
    }

    private void selectPlaylist() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement selectPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"#!/playlist/27350\"]")));
        selectPlaylist.click();
    }

    private void pressDeletePlaylist() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement delPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title=\"Delete this playlist\"]")));
        delPlaylist.click();
    }

    private String getConfirmationPopupText() {
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }

}