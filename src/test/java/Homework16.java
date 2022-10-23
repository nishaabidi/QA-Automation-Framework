import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {

    @Test
    public static void createNewPlaylist() throws InterruptedException {

        String url = "https://bbb.testpro.io/";

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("nishaabidi@yahoo.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("Mylife#1234");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/form/button"));
        loginButton.click();


        WebElement btnPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/h1/i"));
        btnPlaylist.click();

        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        newPlaylist.click();

        WebElement namePlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/form/input"));
        namePlaylist.sendKeys("HW16");
        namePlaylist.sendKeys(Keys.RETURN);

        WebElement addedPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        Assert.assertTrue(addedPlaylist.isDisplayed());


        Thread.sleep(3000);
        driver.quit();

    }
}