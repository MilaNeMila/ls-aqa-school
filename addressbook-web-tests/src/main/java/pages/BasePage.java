package pages;

import com.codeborne.selenide.SelenideElement;
import pages.contacts.ContactListPage;
import pages.contacts.CreationContactPage;
import pages.groups.GroupsPage;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    static PageManager pages;

    private final SelenideElement groupsButton = $x("//a[text()='groups']");
    private final SelenideElement contactAddButton = $x("//a[text()='add new']");
    private final SelenideElement contactButton = $x("//a[text()='home']");


    public GroupsPage switchToGroupsPage(){
        groupsButton.click();
        return new GroupsPage();
    }

    public CreationContactPage goToCreateContact(){
        contactAddButton.click();
        return new CreationContactPage();
    }

    public ContactListPage goToContactList(){
        contactButton.click();
        return new ContactListPage();
    }

    public static PageManager pages() {
        return pages;
    }


}
