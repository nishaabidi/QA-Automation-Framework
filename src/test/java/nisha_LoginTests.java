
import POM.pages.LoginPage;
import my.POM.pages.MyLoginPage;
import org.testng.annotations.Test;


import javax.swing.*;
import java.time.Duration;

public class nisha_LoginTests extends MyBaseTest {

    //lets try login methods first

    @Test
    public void testLoginPOM(){
        LoginPage loginPage = new LoginPage(driver);
        //we create an object of our login page to access its methods
        loginPage.login();
        //now lets add this java class to our testNG xml file

//        i tried running the test in testng xml to see the complete error
//        we have an error because of the missing parameter "baseurl" in our base test class ,launch browser method



        //lets create our own basetest class to avoid conflicts in the future
        // then lets extend our tests to it

//        i think we are good. we can put our login tests in this class
    }



    @Test
    public void myLoginTests(){
//        to be able to access our methods in MyLoginPage, we will create an object of it here
        MyLoginPage myLoginPage = new MyLoginPage(driver); //our driver would be passed here
//        next, lets retrieve our methods, as we can see, all our methods our available,
//        the ones in the MyBasePage, and in MyLoginPage, since we extended/inherited MyBasePage
        myLoginPage.enterEmail("test");
        myLoginPage.enterPassword("test");
//        now we were able to access our enter email and enter password method from MyLoginPage
//        let's try to run it'
        //and now it runs, and our codes looks cleaner now because of POM
//        is everying clear so far?

//        are you asokking about the email add methods?yes did you put it in
//                like my emaiil and pass
//                i did not use your email and pass yet, but you could put it either here in the tests, or in
//                the MyLoginPage

//        so basically our POM organizes our code structure, separating methods and web elements per page
//       let me end the sssion here and please feel free to send questions in our slack
    }


}
