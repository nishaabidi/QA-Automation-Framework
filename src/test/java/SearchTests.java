import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.awt.*;


//user logs in
//inputs search text/phrase
//results show up in right pane


public class SearchTests extends BaseTest {

    @Test
    public void SearchTestBySong() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.SearchBySong();
        Boolean SearchSongResult = homePage.getSearchSongResult();
        Assert.assertEquals(SearchSongResult, true);
    }

    @Test
    public void SearchTestByArtist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.SearchByArtist();
        String SearchArtistResult = homePage.getSearchArtistResult();
        Assert.assertEquals(SearchArtistResult,"Makaih Beats");
    }

    @Test
    public void SearchTestByAlbum() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.SearchByAlbum();
        String SearchAlbumResult = homePage.getSearchAlbumResult();
        System.out.println("======>" + SearchAlbumResult);
        Assert.assertEquals(SearchAlbumResult,"Airbit");
    }

    @Test
    public void NoResult() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.SearchWithNoResult();
        String[] NoneFoundResult = homePage.getNoneFoundResult();
        System.out.println(NoneFoundResult[0] + "=====" + NoneFoundResult[1] + "=====" + NoneFoundResult[2] );
        Assert.assertEquals(NoneFoundResult[2], "None found.");
    }

    @Test
    public void TestCaseSensitive() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.SearchWithCaseSensitive();
        Boolean CaseSensitivity = homePage.checkCaseSensitivity();
        System.out.println(CaseSensitivity);
        Assert.assertEquals(CaseSensitivity, false);
    }

    @Test
    public void TestClearSearchQueryKeyboard() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.ClearSearch();
        Boolean CheckValue =  homePage.checkValue();
        System.out.println(CheckValue);
        Assert.assertEquals(CheckValue, true);
    }

    @Test
    public void TestClearSearchQueryX() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        homePage.ClearSearchX();
        Boolean CheckValue =  homePage.checkValue();
        System.out.println(CheckValue);
        Assert.assertEquals(CheckValue, true);
    }
}
