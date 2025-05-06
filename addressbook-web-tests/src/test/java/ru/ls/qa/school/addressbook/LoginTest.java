package ru.ls.qa.school.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import ru.ls.qa.school.addressbook.BaseTest;


public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    @BeforeEach
    public void openLoginPage(){
        loginPage = new LoginPage();
    }

    @Test
    public void testSuccessfulLogin(){
        loginPage
                .enterUsername("admin")
                .enterPassword("secret")
                .clickLoginButton();
    }

}
