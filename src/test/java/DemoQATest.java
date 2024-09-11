import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQATest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Vodin");
        $("#userEmail").setValue("Vodin@ya.ry");
        $("#currentAddress").setValue("Msk");
        $("#permanentAddress").setValue("SPB");
        $("#submit").click();


        $("#output #name").shouldHave(text("Vodin"));
        $("#output").$("#email").shouldHave(text("Vodin@ya.ry"));
        $("#output").$("#currentAddress").shouldHave(text("Msk"));
        $("#output").$("#permanentAddress").shouldHave(text("SPB"));

    }
}