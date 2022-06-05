package site.stellarburgers.tests;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.stellarburgers.models.CreateOrLoginUserResponse;
import site.stellarburgers.models.User;
import site.stellarburgers.apiOperations.UserOperations;
import site.stellarburgers.pages.LoginPage;
import site.stellarburgers.pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class RegisterTests {

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
    public void registerPositiveTest() {

        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserData();

        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
        String name = registerPage.insertName(user.getName());
        String email = registerPage.insertEmail(user.getEmail());
        String password = registerPage.insertPassword(user.getPassword());
        LoginPage loginPage = registerPage.clickRegisterButton();
        sleep(2000);

        loginPage.insertEmail(email);
        loginPage.insertPassword(password);
        loginPage.clickLoginButton();
        sleep(2000);

        String actualUrlAfterLogin = url();
        String expectedUrlAfterLogin = "https://stellarburgers.nomoreparties.site/";
        assertEquals(expectedUrlAfterLogin, actualUrlAfterLogin);

        String accessToken = useroperations.loginUser(new User(user.getEmail(), user.getPassword())).getBody()
                .as(CreateOrLoginUserResponse.class).getAccessToken();
        useroperations.deleteUser(accessToken);

    }

    @Test
    public void registerWithInvalidPassword() {

        UserOperations useroperations = new UserOperations();
        User user = useroperations.generateUserDataWithInvalidPassword();

        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
        registerPage.insertName(user.getName());
        registerPage.insertEmail(user.getEmail());
        registerPage.insertPassword(user.getPassword());
        registerPage.clickRegisterButton();
        registerPage.checkInvalidPasswordWarning();

    }

}
