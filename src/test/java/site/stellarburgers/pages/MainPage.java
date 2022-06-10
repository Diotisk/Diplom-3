package site.stellarburgers.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.XPATH, using = (".//button[text()='Войти в аккаунт']"))
    private SelenideElement loginButton;

    @FindBy(how = How.LINK_TEXT, using = ("Личный Кабинет"))
    private SelenideElement profileButton;

    @FindBy(how = How.XPATH, using = (".//span[text()='Булки']"))
    private SelenideElement bugs;

    @FindBy(how = How.XPATH, using = (".//h2[text()='Булки']"))
    private SelenideElement bugsHeader;

    @FindBy(how = How.XPATH, using = (".//span[text()='Соусы']"))
    private SelenideElement sauces;

    @FindBy(how = How.XPATH, using = (".//h2[text()='Соусы']"))
    private SelenideElement saucesHeader;

    @FindBy(how = How.XPATH, using = (".//span[text()='Начинки']"))
    private SelenideElement fillings;

    @FindBy(how = How.XPATH, using = (".//h2[text()='Начинки']"))
    private SelenideElement fillingsHeader;

    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    public LoginPage clickProfileButton() {
        profileButton.click();
        return page(LoginPage.class);
    }

    public void clickBugs() {
        bugs.click();
    }

    public void checkBugsHeader() {
        bugsHeader.shouldBe(Condition.visible);
    }

    public void clickSauces() {
        sauces.click();
    }

    public void checkSaucesHeader() {
        saucesHeader.shouldBe(Condition.visible);
    }

    public void clickFillings() {
        fillings.click();
    }

    public void checkFillingsHeader() {
        fillingsHeader.shouldBe(Condition.visible);
    }

}
