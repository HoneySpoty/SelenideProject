package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.WebDriverConditions.url;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;

public class CrtHomePage {
    private final SelenideElement pageContacts = $x("//a[@href='/contacts']");
    private final SelenideElement burgerMenu = $x("//input[@type='checkbox']");


    @Step("Клик на бургер меню")
    public void clickBurgerMenu() {
        burgerMenu.should().click();
    }

    @Step("Клик на контакты")
    public void clickPageContacts() {
        pageContacts.should(Condition.enabled).click();
    }

    @Step("Проверка корректности урла")
    public void verifySuccessRedirect() {
        webdriver().shouldHave(url("https://crtweb.ru/"));
    }

}
