package ru.ls.qa.school.addressbook;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.PageManager;
import tools.ConfigHelper;
import tools.DriverConfig;
import tools.WebConfig;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public static final Faker faker = new Faker();
    public static final PageManager getPage = PageManager.init();
    private static final DriverConfig DRIVER_CONFIG = ConfigHelper.getDriverConfig();
    private static final WebConfig URL_CONFIG = ConfigHelper.getWebConfig();

    @BeforeAll
    public static void setup(){
        Configuration.browser = DRIVER_CONFIG.browser();
        Configuration.baseUrl = URL_CONFIG.baseUrl();
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;

        open("/");
        getPage.loginPage()
               .enterUsername("admin")
               .enterPassword("secret")
               .clickLoginButton();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    public PageManager pages(){
        return getPage;
    }
}
