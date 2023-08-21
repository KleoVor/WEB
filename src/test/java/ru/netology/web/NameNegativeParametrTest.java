package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NameNegativeParametrTest {

    @ParameterizedTest
    @CsvSource({
            "bbbb, \'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.\'",
            "Иван5, \'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.\'",
            "Иван_, \'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.\'",
            ", \'Поле обязательно для заполнения\'",
            "ИванИванов, \'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.\'"

    })

    public void shouldBeNegativeParametrsTestName(String inputValue, String expectedValue) {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue(inputValue);
        form.$("[data-test-id=phone] input").setValue("+79670000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(text(expectedValue));
    }

    @ParameterizedTest
    @CsvSource({
            ",Поле обязательно для заполнения",
            "7+1234564545, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
            "89671234545, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
            "+7123 4564545, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
            "+7-1234564545, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
            "-71234564545, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
            "+7123564545, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
            "f, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
            "м, \'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\'",
    })


    public void shouldBeNegativeParamersTestPhone(String inputValue, String expectedValue) {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Иван Петров-Водкин");
        form.$("[data-test-id=phone] input").setValue(inputValue);
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(text(expectedValue));
    }
}
