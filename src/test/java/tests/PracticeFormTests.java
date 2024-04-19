package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("user@mail.ru");
        $("#gender-radio-1+label").click();
        $("#userNumber").setValue("79268130933");
        $("#dateOfBirth #dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--008").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1+label").click();
        $("#hobbies-checkbox-2+label").click();
        $("#hobbies-checkbox-3+label").click();
        $("#uploadPicture").scrollIntoView(true);
        $("#uploadPicture").uploadFromClasspath("Capture.JPG");
        $("#currentAddress").setValue("USA");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("[class=table-responsive]").shouldHave(text("Alex Smith"));
        $("[class=table-responsive]").shouldHave(text("user@mail.ru"));
        $("[class=table-responsive]").shouldHave(text("Male"));
        $("[class=table-responsive]").shouldHave(text("7926813093"));
        $("[class=table-responsive]").shouldHave(text("08 November,1992"));
        $("[class=table-responsive]").shouldHave(text("Maths"));
        $("[class=table-responsive]").shouldHave(text("Sports, Reading, Music"));
        $("[class=table-responsive]").shouldHave(text("Capture.JPG"));
        $("[class=table-responsive]").shouldHave(text("USA"));
        $("[class=table-responsive]").shouldHave(text("NCR Delhi"));
    }
}