package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddressbookPage {

    private final SelenideElement groupsButton = $x("//a[text()='groups']");

    public AddressbookPage switchToGroupsPage(){
        groupsButton.click();
        return this;
    }
}
