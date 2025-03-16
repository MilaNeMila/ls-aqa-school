package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameField = $("input[name='user']");
    private final SelenideElement passwordField = $("input[name='pass']");
    private final SelenideElement loginButton = $("input[type='submit']");


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
