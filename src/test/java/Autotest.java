import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Autotest {
    @Test
    void testHtmlFile() {
        // 1. Открываем HTML-файл
        String path = new File("src/test/resources/tests/autotests.html").getAbsolutePath();
        open("file://" + path);

        // 2. Проверяем заголовок страницы
        title().equals("Мой автотест");

        // 3. Проверяем наличие элемента
        $("#header").shouldHave(text("Тестовая страница"));

        // 4. Кликаем кнопку (пример)
        $("#myButton").click();

        // 5. Делаем скриншот (сохранится в build/reports/tests)
        screenshot("autotest-result");
    }
}