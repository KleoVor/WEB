[![Java CI with Gradle](https://github.com/KleoVor/WEB/actions/workflows/gradle.yml/badge.svg)](https://github.com/KleoVor/WEB/actions/workflows/gradle.yml)

# Внимание! 
Проверка CI показывает ошибку, т.к. один из негативных тестов нашел баг в коде, заведен issue на баг.
Остальные негативные тесты проходят проходят


# Задача 1
Необходимо автоматизировать тестирование формы заказа карты.

*Требования к содержимому полей:*
1. В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
2. В поле телефона — только 11 цифр, символ + на первом месте.
3. Флажок согласия должен быть выставлен.
*Тестируемая функциональность:* отправка формы.

*Условия:* если все поля заполнены корректно, то вы получаете сообщение об успешно отправленной заявке

Необходимо самостоятельно изучить элементы на странице, чтобы подобрать правильные селекторы.
Проект с автотестами должен быть выполнен на базе Gradle с использованием Selenide или Selenium по выбору студента.

Для запуска тестируемого приложения скачайте JAR-файл из текущего каталога и запускайте его командой: java -jar app-order.jar.
Приложение будет запущено на порту 9999.

Если по каким-то причинам порт 9999 на вашей машине используется другим приложением, используйте:
java -jar app-order.jar -port=7777

Убедиться, что приложение работает, вы можете, открыв в браузере страницу: http://localhost:9999.


# Задача №2: проверка валидации (необязательная)

После того как вы протестировали happy path, необходимо протестировать остальные варианты.

*Тестируемая функциональность:* валидация полей перед отправкой.

*Условия:* если какое-то поле не заполнено или заполнено неверно, то при нажатии на кнопку «Продолжить» должны появляться сообщения об ошибке.
Будет подсвечено только первое неправильно заполненное поле
