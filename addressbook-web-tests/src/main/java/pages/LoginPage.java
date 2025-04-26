package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameField = $("input[name='user']"),
            passwordField = $("input[name='pass']"),
            loginButton = $("input[type='submit']");

    public LoginPage enterUsername(String username){
        usernameField.setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwordField.setValue(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }
}
