import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 {

    @Test
    public static void search() throws InterruptedException {

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

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Pluto");

//        WebElement song = driver.findElement(By.cssSelector("[class='details']"));
//        WebElement song = driver.findElement(By.cssSelector("[class='songs']>ul>article>span:nth-child(2)"));
        WebElement song = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/ul/article/span[2]/span[1]"));
        Assert.assertTrue(song.isDisplayed());


        System.out.println(song.getText());

        Thread.sleep(3000);
        driver.quit();

    }
}