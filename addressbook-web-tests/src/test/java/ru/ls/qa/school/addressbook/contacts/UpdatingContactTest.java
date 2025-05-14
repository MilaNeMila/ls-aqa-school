package ru.ls.qa.school.addressbook.contacts;

import com.codeborne.selenide.Selenide;
import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.contacts.ContactListPage;
import ru.ls.qa.school.addressbook.BaseTest;

public class UpdatingContactTest extends BaseTest {
    private final BasePage basePage = new BasePage();
    private final ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(faker.name().firstName())
            .contactLastName(faker.name().lastName())
            .nicknameContactName(faker.name().firstName())
            .build();

    @BeforeEach
    public void checkingContactOnPages(){
        ContactListPage contactListPage = basePage.goToContactList();
        if (ContactListPage.checkingContactsOnPage()){
            basePage.goToCreateContact()
                    .fillContactForm(contactData)
                    .clickCreateContactButton();
        }
        else {
            ContactListPage.getFirstContact(contactData);
        }

    }

    @Test
    @DisplayName("��������� ��������")
    public void testEditContact(){
        ContactListPage contactListPage = basePage.goToContactList()
                                                  .editCreatedContact(contactData)
                                                  .updateContactForm(contactData)
                                                  .clickCreateContactButton();
    }

    @AfterEach
    public void removeCreatedContact(){
        basePage.goToContactList().removeContact(contactData);
    }
}
