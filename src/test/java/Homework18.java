import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {


    @Test
    public void playSong() throws InterruptedException {
        //login
        provideEmail("demo@class.com");
        providePassword();
        clickSubmitBtn();

        playASong();
        validateSongIsPlaying();

    }
    private void playASong() throws InterruptedException {

        WebElement nextBtn = driver.findElement(By.xpath("//i[@data-testid=\"play-next-btn\"]"));
        nextBtn.click();

        Thread.sleep(2000);

        WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid=\"play-btn\"]"));
        playPauseBtn.click();

    }

    private void validateSongIsPlaying() {

        WebElement visualizer = driver.findElement(By.xpath("//button[@title=\"Click for a marvelous visualizer!\"]"));
        Assert.assertTrue(visualizer.isDisplayed());
    }


}


