package pages;

import pages.contacts.ContactListPage;
import pages.contacts.CreationContactPage;

public class PageManager {

    private static PageManager instance;

    private PageManager(){
        instance.contactListPage = new ContactListPage();
        instance.creationContactPage = new CreationContactPage();
        instance.loginPage = new LoginPage();
    }

    private ContactListPage contactListPage;
    private CreationContactPage creationContactPage;
    private LoginPage loginPage;

    public static PageManager init() {
        if (instance == null) {
            instance = new PageManager();
            BasePage.pages = instance;
        }
        return instance;
    }

    public ContactListPage contactList() {
        return contactListPage;
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public CreationContactPage getCreatingContactPage(){
        return creationContactPage;
    }
}
