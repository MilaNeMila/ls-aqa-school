package pages;

import com.codeborne.selenide.SelenideElement;
import pages.contacts.AddressbookPage;
import pages.contacts.CreatingContactPage;
import pages.groups.GroupsPage;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    private final SelenideElement groupsButton = $x("//a[text()='groups']");
    private final SelenideElement contactAddButton = $x("//a[text()='add new']");
    private final SelenideElement contactButton = $x("//a[text()='home']");


    public GroupsPage switchToGroupsPage(){
        groupsButton.click();
        return new GroupsPage();
    }

    public CreatingContactPage switchToCreatingContactPage(){
        contactAddButton.click();
        return new CreatingContactPage();
    }

    public AddressbookPage switchToAddressbookPage(){
        contactButton.click();
        return new AddressbookPage();
    }
}
