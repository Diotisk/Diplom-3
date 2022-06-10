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
import site.stellarburgers.pages.*;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertEquals;

public class LoginTests {

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

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @Test
    public void loginFromMainPageWithSignInButtonPositiveTest() {

        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserData();
        Response createUserApiResponse = useroperations.createUser(user);

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();

        loginPage.insertEmail(user.getEmail());
        loginPage.insertPassword(user.getPassword());
        AccountPage accountPage = loginPage.clickLoginButton();

        ProfilePage profilePage = accountPage.clickAccountButton();
        assertEquals(user.getName(), profilePage.getUserName());
        assertEquals(user.getEmail().toLowerCase(Locale.ROOT), profilePage.getUserEmail());

        useroperations.deleteUser(createUserApiResponse.getBody().as(CreateOrLoginUserResponse.class)
                .getAccessToken());

    }

    @Test
    public void loginFromMainPageWithProfileButtonPositiveTest() {

        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserData();
        Response createUserApiResponse = useroperations.createUser(user);

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        LoginPage loginPage = mainPage.clickProfileButton();

        loginPage.insertEmail(user.getEmail());
        loginPage.insertPassword(user.getPassword());
        AccountPage accountPage = loginPage.clickLoginButton();

        ProfilePage profilePage = accountPage.clickAccountButton();
        assertEquals(user.getName(), profilePage.getUserName());
        assertEquals(user.getEmail().toLowerCase(Locale.ROOT), profilePage.getUserEmail());

        useroperations.deleteUser(createUserApiResponse.getBody().as(CreateOrLoginUserResponse.class)
                .getAccessToken());

    }

    @Test
    public void LoginFromRegisterPagePositiveTest() {
        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserData();
        Response createUserApiResponse = useroperations.createUser(user);

        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
        LoginPage loginPage = registerPage.clickSignInButton();

        loginPage.insertEmail(user.getEmail());
        loginPage.insertPassword(user.getPassword());
        AccountPage accountPage = loginPage.clickLoginButton();

        ProfilePage profilePage = accountPage.clickAccountButton();
        assertEquals(user.getName(), profilePage.getUserName());
        assertEquals(user.getEmail().toLowerCase(Locale.ROOT), profilePage.getUserEmail());

        useroperations.deleteUser(createUserApiResponse.getBody().as(CreateOrLoginUserResponse.class)
                .getAccessToken());

    }

    @Test
    public void LoginFromForgotPasswordPagePositiveTest() {

        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserData();
        Response createUserApiResponse = useroperations.createUser(user);

        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password",
                ForgotPasswordPage.class);
        LoginPage loginPage = forgotPasswordPage.clickSignInButton();

        loginPage.insertEmail(user.getEmail());
        loginPage.insertPassword(user.getPassword());
        AccountPage accountPage = loginPage.clickLoginButton();

        ProfilePage profilePage = accountPage.clickAccountButton();
        assertEquals(user.getName(), profilePage.getUserName());
        assertEquals(user.getEmail().toLowerCase(Locale.ROOT), profilePage.getUserEmail());

        useroperations.deleteUser(createUserApiResponse.getBody().as(CreateOrLoginUserResponse.class)
                .getAccessToken());

    }

}
