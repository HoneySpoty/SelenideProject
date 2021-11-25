package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class CrtWebContactPage {
    private final SelenideElement checkNumber = $x("(//a[@href='tel:+74991136889'])[3]");
    private final SelenideElement checkEmail = $x("(//a[text()='sales8@crtweb.ru'])[2]");


    @Step("Проверка корректности номера")
    public void verifyCheckNumber(){
        checkNumber.should(Condition.appear);
    }

    @Step("Проверка корректности почты")
    public void verifyCheckEmail() {
        checkEmail.should(Condition.appear);
    }
}

