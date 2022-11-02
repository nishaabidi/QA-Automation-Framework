import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        // Step1: Log in with your credentials
        logIn();
        // Step2: Choose a playlist
        selectPlaylist();
        // Step3: Delete the playlist
        pressDeletePlaylist();
        // Step4: Validate that the playlist is deleted "Deleted playlist"
        Assert.assertEquals(getConfirmationPopupText(), "Deleted playlist \"HW19 - 3.\"");
    }

    private void selectPlaylist() throws InterruptedException {
        WebElement selectPlaylist = driver.findElement(By.xpath("//a[@href=\"#!/playlist/26976\"]"));
        selectPlaylist.click();
        Thread.sleep(5000);
    }

    private void pressDeletePlaylist() throws InterruptedException {
        WebElement delPlaylist = driver.findElement(By.xpath("//button[@title=\"Delete this playlist\"]"));
        delPlaylist.click();
        Thread.sleep(3000);
    }

    private String getConfirmationPopupText() {
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }

}