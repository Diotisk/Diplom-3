package site.stellarburgers.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BurgerBuilderTests {

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
    public void checkSaucesPositiveTest() {

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickSauces();
        sleep(3000);
        mainPage.checkSaucesHeader();

    }

    @Test
    public void checkFillingsPositiveTest() {

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickFillings();
        sleep(3000);
        mainPage.checkFillingsHeader();

    }

    @Test
    public void checkBugsPositiveTest() {

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickFillings();
        sleep(3000);
        mainPage.clickBugs();
        sleep(3000);
        mainPage.checkBugsHeader();

    }

}
