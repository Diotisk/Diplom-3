package site.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = (".//input[contains(@name, 'Name')]"))
    private SelenideElement userName;

    @FindBy(how = How.XPATH, using = (".//input[contains(@name, 'name')]"))
    private SelenideElement userEmail;

    @FindBy(how = How.LINK_TEXT, using = ("Конструктор"))
    private SelenideElement burgerBuilderButton;

    @FindBy(how = How.CLASS_NAME, using = ("AppHeader_header__logo__2D0X2"))
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = (".//button[text()='Выход']"))
    private SelenideElement logOutButton;

    public String getUserName() {
        return userName.getValue();
    }

    public String getUserEmail() {
        return userEmail.getValue();
    }

    public MainPage clickBurgerBuilderButton() {
        burgerBuilderButton.click();
        return page(MainPage.class);
    }

    public MainPage clickLogo() {
        logo.click();
        return page(MainPage.class);
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

}
