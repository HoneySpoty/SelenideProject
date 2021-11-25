package steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.*;
import io.qameta.allure.*;


public class TestSteps {
    CrtWebContactPage crtContactPage = Selenide.page(CrtWebContactPage.class);
    CrtHomePage crtHomePage = Selenide.page(CrtHomePage.class);
    GoogleSearchPage googleSearchPage = Selenide.page(GoogleSearchPage.class);

    @BeforeAll
    static void setupAll(){
        Configuration.headless=true;
        Configuration.clickViaJs=true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @ExtendWith({TextReportExtension.class})

    @Test
    @Description("Тест crtweb")
    public void testCrtWeb1() {
        googleSearchPage.openGooglePage();
        googleSearchPage.setCheckWrightPage();
        googleSearchPage.clickLinkCrt();
        crtHomePage.verifySuccessRedirect();
        crtHomePage.clickBurgerMenu();
        crtHomePage.clickPageContacts();
        crtContactPage.verifyCheckNumber();
        crtContactPage.verifyCheckEmail();

    }

}

