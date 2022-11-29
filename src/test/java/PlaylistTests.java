import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void createPlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Super Songs");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists + 1, "Playlist not created");
    }

    @Test

    public void createPlaylistWithSameName() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        String msg = homePage.getDuplicatePlaylist("Super Songs");
        Assert.assertEquals(msg, "This playlist name already exists!");
    }

    @Test
    public void createTwoCharPlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("OK");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists +1, "Playlist not created");
    }



    @Test
    public void createElevenCharPlaylist() throws InterruptedException {
        HomePage homePage = new LoginPage(driver).login();
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Life is Beautiful");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists +1, "Playlist not created");
    }
}

