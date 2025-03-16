package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    public static void setup(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://localhost:8080/addressbook";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUp() {
        // Открытие браузера перед каждым тестом
        open("/"); // Указываем базовый URL для тестов
    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера после каждого теста
        Selenide.closeWebDriver();
    }
}
