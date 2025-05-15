package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameField = $("input[name='user']"),
            passwordField = $("input[name='pass']"),
            loginButton = $("input[type='submit']");

    @Step("Заполнить логин")
    public LoginPage enterUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    @Step("Заполнить пароль")
    public LoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажать кнопку авторизации")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
