package site.stellarburgers.tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class GoToProfileTest {

        /*
    ChromeDriver driver;

    @Before
    public void setUp(){
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
    public void goToProfilePositiveTest() {

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickProfileButton();

        String actualUrl = url();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        assertEquals(expectedUrl, actualUrl);

    }

}
