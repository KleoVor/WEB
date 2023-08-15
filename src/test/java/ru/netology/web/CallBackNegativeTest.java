package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CallBackNegativeTest {
    @Test
    void NameLatiniza() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Nata");
        form.$(".button_theme_alfa-on-white").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

        Thread.sleep(5000);


    }

    @Test
    void NameNumer() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Ната5");
        form.$(".button_theme_alfa-on-white").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

        Thread.sleep(5000);
    }

    @Test
    void NameUnderline() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Ната_");
        form.$(".button_theme_alfa-on-white").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

        Thread.sleep(5000);
    }

    @Test
    void NameNoSurname() throws InterruptedException {

        // Этот тест не проходит, хотя должно быть Имя и Фамилия. Т.е. должен быть пробел в поле Надо оформить Ussue

        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("ИванИванов");
        form.$(".button_theme_alfa-on-white").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

        Thread.sleep(5000);
    }

    @Test
    void NameNull() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=name] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

        Thread.sleep(5000);
    }

    @Test
    void PhoneNull() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

        Thread.sleep(5000);
    }


    @Test
    void PhonePlusplusSignIsNotTheFirst() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("7+1111234567");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void PhoneSpace() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+7111 1234567");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void PhoneParenthes() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+7111(1234567");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }


    @Test
    void Phone1() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("1");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void Phone10() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("1234567890");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void Phone11() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("12345678901");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void Phone11AndMinus() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("-12345678901");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void Phone11AndLetter() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+1234567890F");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void PhoneWhisoutPlus() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("89670000000");
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

        Thread.sleep(5000);
    }

    @Test
    void AgreementColor() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Иванов-Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue("+79670000000");

        SelenideElement textElement = $(By.cssSelector(".checkbox__text"));
        String initialColor = textElement.getCssValue("color");

        form.$(".button_theme_alfa-on-white").click();

        String updatedColor = textElement.getCssValue("color");
        assertNotEquals(initialColor, updatedColor);
        //   assertEquals(initialColor, updatedColor);
        // строкой выше проверяла, что тест падает


        Thread.sleep(5000);
    }


//    @Test
//    void NameMinSize() throws InterruptedException {
//
//        //// По условию нет минимального размера имени/фамилии Нет и максимального. В реальных условиях - надо тестировать
//
//        open("http://localhost:9999");
//        SelenideElement form = $(".form_theme_alfa-on-white");
//
//        form.$("[data-test-id=name] input").setValue("И");
//        form.$(".button_theme_alfa-on-white").click();
//        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
//
//        Thread.sleep(5000);
//    }


}
