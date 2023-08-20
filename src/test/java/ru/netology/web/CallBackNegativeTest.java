package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallBackNegativeTest {
    @Test
    void shouldEnterNameLatin() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Nata");
        form.$("[data-test-id=phone] input").setValue("+79670000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldEnterNameWithNumber() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Ната5");
        form.$("[data-test-id=phone] input").setValue("+79670000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldEnterNameWithUnderline() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Ната_");
        form.$("[data-test-id=phone] input").setValue("+79670000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldEnterNameWithoutSpace() {

        // Этот тест не проходит, хотя должно быть Имя и Фамилия. Т.е. должен быть пробел в поле Надо оформить issue

        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("ИванИванов");
        form.$("[data-test-id=phone] input").setValue("+79670000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldEnterNameEmpty() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("");
        form.$("[data-test-id=phone] input").setValue("+79670000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldEnterPhoneEmpty() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

    }

    @Test
    void shouldEnterPlusSignIsNotTheFirst() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("7+1111234567");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEnterPhoneSpace() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+7111 1234567");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEnterPhoneBracket() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+7111(1234567");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }


    @Test
    void shouldEnterSingleDigitPhoneNumber() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("1");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEnterTenDigitPhoneNumber() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("1234567890");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEnterSElevenDigitPhoneNumber() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("12345678901");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEnterElevenDigitPhoneNumberAndMinus() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("-12345678901");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEnterElevenDigitPhoneNumberAndLetter() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+1234567890F");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEnterPhoneNumberWithoutPlus() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("89670000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldAgreementColor() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+79670000000");
        form.$(".button_theme_alfa-on-white").click();
        $(By.cssSelector("[data-test-id=agreement].input_invalid")).shouldBe(visible);
    }
}
