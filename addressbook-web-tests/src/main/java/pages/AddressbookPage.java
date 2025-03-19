package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddressbookPage {

    private final SelenideElement groupsButton = $x("//a[text()='groups']"),
    contactAddButton = $x("//a[text()='add new']");

    public GroupsPage switchToGroupsPage(){
        groupsButton.click();
        return new GroupsPage();
    }
    public AddressbookPage switchToAddingContactPage(){
        contactAddButton.click();
        return this;
    }
}

