package test;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
    }

    @Test
    public void verifyLoginTest1() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String title = homePage.homeTitles();
        softAssert.assertEquals(title, "Welcome to Lead Management System", "title should be Welcome to Lead Management System");
        softAssert.assertAll();
    }

    @Test
    public void verifyLoginTest2() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String title = homePage.homeTitles();
        softAssert.assertEquals(title, "Welcome to Lead Management System", "title should be Welcome to Lead Management System");
        softAssert.assertAll();
    }

    @Test
    public void verifyLoginTest3() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String title = homePage.homeTitles();
        softAssert.assertEquals(title, "Welcome to Lead Management System", "title should be Welcome to Lead Management System");
        softAssert.assertAll();
    }

    @Test
    public void verifyBrokenLinks(){
//        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.urlListExample();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

}
