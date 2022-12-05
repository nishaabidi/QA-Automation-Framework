import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.awt.*;


//user logs in
//is on the home page
//clicks on all songs
//click on the song
//click on the favorite icon

public class FavoritesTests extends BaseTest {

    @Test
    public void FavoritesTestMethod_1() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.createFavoriteList();
        String SongInFavorites = homePage.getSongInFavorites();
        Assert.assertEquals(SongInFavorites, "Unlike Episode 2 by Music Insiders By Fma");
    }

    @Test
    public void FavoritesTestMethod_2() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.setFavoriteThruAddButton();
        String FavoriteSongAddButton = homePage.getSongInFavoritesAddButton();
        Assert.assertEquals(FavoriteSongAddButton, "Unlike Reactor by Xylo-Ziko");
    }

    @Test
    public void FavoritesTestMethod_3() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.setFavoriteThruContextMenu();
        String FavoriteSongContext = homePage.getSongInFavoritesContext();
        Assert.assertEquals(FavoriteSongContext, "Unlike Episode 2 by Music Insiders By Fma");
    }


    @Test
    public void DeleteTestMethod_1() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.DeleteFavoriteList();
        String NoFavoritesYet = homePage.FavoritesEmpty();
        Assert.assertEquals(NoFavoritesYet, "text");
    }

    @Test
    public void DeleteTestMethod_2() throws InterruptedException, AWTException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.DeleteFavoriteListWithKey();
//        String NoFavoritesYet = homePage.FavoritesEmpty();
//        Assert.assertEquals(NoFavoritesYet, "text");
    }
}
