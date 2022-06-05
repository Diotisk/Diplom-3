package site.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AccountPage {

    @FindBy(how = How.LINK_TEXT, using = ("Личный Кабинет"))
    private SelenideElement accountButton;

    public ProfilePage clickAccountButton() {
        accountButton.click();
        return page(ProfilePage.class);
    }

}
