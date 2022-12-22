package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement createPlaylistButton;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistOption;

    @FindBy(css = "[name='name']")
    WebElement playlistNameField;

    @FindBy(css = "a[href='#!/songs']")
    WebElement AllSongs;

    @FindBy(css = "button[title='Like Episode 2 by Music Insiders By Fma']" )
    WebElement SelectFavoriteSong;

    @FindBy(css = "button[title='Unlike Episode 2 by Music Insiders By Fma']")
    WebElement SongInFavorites;

//    @FindBy(css = "tr[class='song-item selected']")
//    WebElement SelectedSongRow;

    @FindBy(xpath = "//*[contains(text(), 'Reactor')]")
    WebElement SelectSong;

    @FindBy(css = "button.btn-add-to")
    WebElement ButtonAddTo;

    @FindBy(css = "li[class='favorites']")
    WebElement FavoritesLi;

    @FindBy(css = "button[title='Unlike Reactor by Xylo-Ziko']")
    WebElement FavoriteSongAddButton;

    @FindBy(css = "button[title='Unlike Episode 2 by Music Insiders By Fma']")
    WebElement FavoriteSongContext;

    @FindBy(xpath = "//*[contains(text(), 'Episode 2')]")
    WebElement SelectSongContext;

    @FindBy(css = "li[class='has-sub']")
    WebElement AddToContext;

    @FindBy(css = "li[class='favorite']")
    WebElement FavoriteLiContext;

    @FindBy(xpath ="//*[contains(text(), 'No favorites yet')]")
    WebElement NoFavoritesYet;

    @FindBy(css = "a[href='#!/favorites']")
    WebElement FavoritesLink;

    @FindBy(xpath = "//body/div[@id='app']/div[@id='main']/div[@id='mainWrapper']/section[@id='mainContent']/section[@id='favoritesWrapper']/div[1]/div[1]/div[1]/table[1]/tr[1]/td[2]")
    WebElement SongToDeleteWithKey;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/section[1]/section[7]/div[1]/div[1]/div[1]/table[1]")
    WebElement SongToDeleteWithClick;


    @FindBy(css = "#favoritesWrapper > div > div > div.item-container > table > tr[class='song-item selected']")
    WebElement Dummy;

////    @FindBy(css = "#playlists > form > input[type=text]" )
//    @FindBy(css = "//*[@id='playlists']/form/input")
//    WebElement enteredName;

    @FindBys(
            @FindBy(css = "#playlists a[href*='playlist']")
    )
    List<WebElement> playlists;


    public HomePage(WebDriver sentDriver) {
        super(sentDriver);
    }

    public void createPlaylist(String name) throws InterruptedException {
        createPlaylistButton.click();
        newPlaylistOption.click();
        playlistNameField.sendKeys(name);
        playlistNameField.sendKeys(Keys.RETURN);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[name='name']")));
    }


    public String getDuplicatePlaylist(String name) throws InterruptedException {
        createPlaylistButton.click();
        newPlaylistOption.click();

        String msg = "";
        boolean dupFlag = isNameDuplicate(name); // This will return true or false
        System.out.println("dupFlag = " + dupFlag);
        if(!dupFlag){
            playlistNameField.sendKeys(name);
            playlistNameField.sendKeys(Keys.RETURN);
        }
        else {
            msg = "This playlist name already exists!";
            System.out.println(name + " already exists!");
        }
        return msg;
    }

    public boolean isNameDuplicate(String name){
        //System.out.println( "playlists.size() = " + playlists.size());
        boolean blnFound = false;
        for(int i=0; i < playlists.size(); i++){
            String currItem = playlists.get(i).getText();
            System.out.println(String.valueOf(i) + " >> [" + name + "] == [" + currItem +"]");
            if (currItem.equals(name)) {
                blnFound = true;
                break;
            }
        }
        return blnFound;
    }

    public int getNumberOfPlaylist() {
        return playlists.size();
    }

    //Create Favorite List
    public void createFavoriteList() throws InterruptedException {
        AllSongs.click();
        SelectFavoriteSong.click();
    }

    public String getSongInFavorites(){
        return SongInFavorites.getAttribute("title");
    }

    public String getSongInFavoritesAddButton(){
        return FavoriteSongAddButton.getAttribute("title");
    }

    public String getSongInFavoritesContext(){ return FavoriteSongContext.getAttribute("title"); }

    public void setFavoriteThruAddButton() throws InterruptedException {
        AllSongs.click();
        SelectSong.click();
        ButtonAddTo.click();
        FavoritesLi.click();
    }

    public void getContextMenu(){
        Actions actions = new Actions(driver);
        actions.contextClick(SelectSongContext).perform();
    }

    public void setFavoriteThruContextMenu() throws InterruptedException {
        AllSongs.click();
        getContextMenu();
        AddToContext.click();
        FavoriteLiContext.click();
    }

    public String FavoritesEmpty(){
        return NoFavoritesYet.getAttribute("class");
    }

    public void DeleteFavoriteList() throws InterruptedException{
        AllSongs.click();
        SelectFavoriteSong.click();
        SongInFavorites.click();
    }

    public void DeleteFavoriteListWithKey() throws InterruptedException, AWTException {
//        AllSongs.click();
//        SelectFavoriteSong.click();
        FavoritesLink.click();
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[7]/div[1]/div[1]/div[1]/table[1]/tr[1]/td[2]")));
        SongToDeleteWithKey.click();
        Thread.sleep(2000);
        actions.moveToElement(SongToDeleteWithKey).build().perform();
//        SongToDeleteWithKey.sendKeys(Keys.DELETE);


        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_DELETE);
        Thread.sleep(2000);

//        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[name='name']")));
    }

    //region --SEARCH WEB ELEMENTS--
    @FindBy(css = "input[type='search']")
    WebElement SearchText;


    @FindBy(xpath =  "//article/span[2]/span[contains(., 'Pluto')]")
//    @FindBy(css = "span[class='details']")
    WebElement SearchSongResult;

    @FindBy(css = "a[href='#!/artist/3']")
    WebElement SearchArtistResult;

    @FindBy(css = "a[href='#!/album/2']")
    WebElement SearchAlbumResult;

//    @FindBy(css = "#searchExcerptsWrapper > div > div > section.songs")
//    @FindBy(xpath = "//*[@id='searchExcerptsWrapper']/div/div/section[1]/p")
//    @FindBy(xpath = "/html/body/div[1]/div/div[1]/section[1]/section[10]/div/div/section[1]/p")
    @FindBy(xpath = "//section[@class='songs']/p")
    WebElement SongNoneFound;

    @FindBy(xpath = "//section[@class='artists']/p")
//    @FindBy(css = "#searchExcerptsWrapper > div > div > section.artists >p")
    WebElement ArtistNoneFound;

    @FindBy(xpath = "//section[@class='albums']/p")
//    @FindBy(css = "#searchExcerptsWrapper > div > div > section.albums >p")
    WebElement AlbumNoneFound;


    //endregion


    //region --SEARCH METHODS--
    public Boolean getSearchSongResult(){
        return SearchSongResult.getAttribute("innerHTML").contains("Pluto");
    }
    public void SearchBySong() throws InterruptedException{
        SearchText.sendKeys(("       Pluto         ").trim());
    }

    public void SearchByArtist() throws InterruptedException{
        SearchText.sendKeys(("     Makaih Beats     ").trim());
    }

    public String getSearchArtistResult(){
        return SearchArtistResult.getText();
    }

    public void SearchByAlbum() throws InterruptedException{
        SearchText.sendKeys(("     Airbit     ").trim());
    }

    public String getSearchAlbumResult(){
        return SearchAlbumResult.getAttribute("innerHTML");
    }

    public void  SearchWithNoResult() throws InterruptedException{
        SearchText.sendKeys("sacrifice");
    }

    public String[] getNoneFoundResult(){
        String[] nonefound = {SongNoneFound.getAttribute("innerHTML"), ArtistNoneFound.getAttribute("innerHTML"), AlbumNoneFound.getAttribute("innerHTML")};
        return nonefound;
    }

    public void  SearchWithCaseSensitive() throws InterruptedException{
        SearchText.sendKeys("pluto");
    }

    public Boolean checkCaseSensitivity(){

        if(SearchSongResult.getAttribute("innerHTML").contains("Pluto")){
            return false;
        }
        else {
            return true;
        }

    }

    public Boolean checkValue(){
        String val = SearchText.getAttribute("value");
        if(val.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    public void ClearSearch() throws InterruptedException{
        SearchText.sendKeys("grav");
        SearchText.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }

    public void ClearSearchX() throws InterruptedException{
        SearchText.sendKeys("grav");
        Actions action = new Actions(driver);
        action.moveByOffset(223, 23).click().build().perform();

    }


    //endregion



}