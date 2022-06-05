package site.stellarburgers.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.stellarburgers.apiOperations.UserOperations;
import site.stellarburgers.models.CreateOrLoginUserResponse;
import site.stellarburgers.models.User;
import site.stellarburgers.pages.AccountPage;
import site.stellarburgers.pages.LoginPage;
import site.stellarburgers.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class GoToBurgerBuilderTests {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    /*
    ChromeDriver driver;

    @Before
    public void setUpYandex(){
        System.setProperty("webdriver.chrome.driver", "/Users/daraeremina/Downloads/yandexdriver");
        driver = new ChromeDriver();
        setWebDriver(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
     */

    @Test
    public void goToBurgerBuilderWithBurgerBuilderButtonPositiveTest() {

        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserData();
        Response createUserApiResponse = useroperations.createUser(user);

        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.insertEmail(user.getEmail());
        loginPage.insertPassword(user.getPassword());
        AccountPage accountPage = loginPage.clickLoginButton();
        ProfilePage profilePage = accountPage.clickAccountButton();

        profilePage.clickBurgerBuilderButton();

        String actualUrl = url();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        assertEquals(expectedUrl, actualUrl);

        useroperations.deleteUser(createUserApiResponse.getBody().as(CreateOrLoginUserResponse.class)
                .getAccessToken());

    }

    @Test
    public void goToBurgerBuilderWithLogoPositiveTest() {

        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserData();
        Response createUserApiResponse = useroperations.createUser(user);

        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.insertEmail(user.getEmail());
        loginPage.insertPassword(user.getPassword());
        AccountPage accountPage = loginPage.clickLoginButton();
        ProfilePage profilePage = accountPage.clickAccountButton();

        profilePage.clickLogo();

        String actualUrl = url();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        assertEquals(expectedUrl, actualUrl);

        useroperations.deleteUser(createUserApiResponse.getBody().as(CreateOrLoginUserResponse.class)
                .getAccessToken());

    }

}
