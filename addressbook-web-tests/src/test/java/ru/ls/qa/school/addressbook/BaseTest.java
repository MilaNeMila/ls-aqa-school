package ru.ls.qa.school.addressbook;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import tools.ConfigHelper;
import tools.DriverConfig;
import tools.WebConfig;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public final Faker faker = new Faker();
    private final LoginPage loginPage = new LoginPage();
    private static final DriverConfig DRIVER_CONFIG = ConfigHelper.getDriverConfig();
    private static final WebConfig URL_CONFIG = ConfigHelper.getWebConfig();

    @BeforeAll
    public static void setup(){
        Configuration.browser = DRIVER_CONFIG.browser();
        Configuration.baseUrl = URL_CONFIG.baseUrl();
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;

    }

    @BeforeEach
    public void setUp() {
        open("/");
        loginPage
                .enterUsername("admin")
                .enterPassword("secret")
                .clickLoginButton();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
