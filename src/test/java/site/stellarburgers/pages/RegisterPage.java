package site.stellarburgers.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    @FindBy(how = How.TAG_NAME, using = ("input"))
    private ElementsCollection registerFields;

    @FindBy(how = How.TAG_NAME, using = ("button"))
    private SelenideElement registerButton;

    @FindBy(how = How.LINK_TEXT, using = ("Войти"))
    private SelenideElement signInButton;

    @FindBy(how = How.XPATH, using=(".//p[text()='Некорректный пароль']"))
    private SelenideElement invalidPasswordWarning;

    public String insertName(String name) {
        registerFields.get(0).setValue(name);
        return name;
    }

    public String insertEmail(String email) {
        registerFields.get(1).setValue(email);
        return email;
    }

    public String insertPassword(String password) {
        registerFields.get(2).setValue(password);
        return password;
    }

    public LoginPage clickRegisterButton() {
        registerButton.click();
        return page(LoginPage.class);
    }

    public LoginPage clickSignInButton() {
        signInButton.click();
        return page(LoginPage.class);
    }

    public void checkInvalidPasswordWarning() {
        invalidPasswordWarning.shouldBe(Condition.visible);
    }

}
