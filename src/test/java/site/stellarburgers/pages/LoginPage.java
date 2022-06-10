package site.stellarburgers.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(how = How.TAG_NAME, using = ("input"))
    private ElementsCollection loginFields;

    @FindBy(how = How.XPATH, using = (".//button[text()='Войти']"))
    private SelenideElement loginButton;

    public void insertEmail(String email) {
        loginFields.get(0).setValue(email);
    }

    public void insertPassword(String password) {
        loginFields.get(1).setValue(password);
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        return page(AccountPage.class);
    }

}
