
import my.POM.pages.MyAllSongsPage;
import my.POM.pages.MyLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class nisha_AllSongsTests extends MyBaseTest {
    //for our class that contains the test methods, we extend to BaseTest (for the webdriver configurations)

//    WebDriver driver;
//    we dont need to decllare webdriver here since it is already in our page objects


    @Test
    public void playSong()   {
//        ( we just need to declare it as an object here)
        MyLoginPage myLoginPage = new MyLoginPage(driver);
        MyAllSongsPage myAllSongsPage = new MyAllSongsPage(driver);


        myLoginPage.login();
        myAllSongsPage.clickOnAllSongs();
        myAllSongsPage.rightClickFirstSong();
        myAllSongsPage.choosePlayOption();
      Assert.assertTrue(myAllSongsPage.isSoundBarDisplayed());

    }
}