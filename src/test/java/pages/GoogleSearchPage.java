package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import io.qameta.allure.*;

public class GoogleSearchPage {
    private final SelenideElement inputGoogle = $x("//input[@name='q']");
    private final SelenideElement checkWrightPage = $x("//h3[text()='Crtweb']");
    private final SelenideElement linkCrt = $x("//*[text()='https://crtweb.ru']");

    @Step("Открытие гугла, ввод crtweb.ru")
    public void openGooglePage() {
        Selenide.open("https://www.google.com");
        inputGoogle.should(Condition.enabled).setValue("https://crtweb.ru").pressEnter();
    }

    @Step("Проверка корректности страницы crt")
    public void setCheckWrightPage() {
        checkWrightPage.should(Condition.appear);
    }

    @Step("Клик на  crt")
    public void clickLinkCrt() {
        linkCrt.should(Condition.enabled).click();
    }
}
