package site.stellarburgers.tests;

import org.junit.Test;
import site.stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class GoToProfileTest {

    @Test
    public void goToProfilePositiveTest() {

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickProfileButton();

        String actualUrl = url();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        assertEquals(expectedUrl, actualUrl);

    }

}
