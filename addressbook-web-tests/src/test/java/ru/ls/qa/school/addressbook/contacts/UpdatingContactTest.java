package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.contacts.AddressbookPage;
import ru.ls.qa.school.addressbook.BaseTest;

public class UpdatingContactTest extends BaseTest {
    private BasePage basePage = new BasePage();
    private final ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(faker.name().firstName())
            .contactLastName(faker.name().lastName())
            .nicknameContactName(faker.name().firstName())
            .build();

    @BeforeEach
    public void checkingContactOnPages(){
        AddressbookPage addressbookPage = basePage.switchToAddressbookPage();
        if (AddressbookPage.checkingContactsOnPage()){
            basePage.switchToCreatingContactPage()
                    .fillContactForm(contactData)
                    .clickCreateContactButton();
        }
        else {
            AddressbookPage.saveCreatedContact(contactData);
        }

    }

    @Test
    @DisplayName("Изменение контакта")
    public void testEditContact(){
        AddressbookPage addressbookPage = basePage.switchToAddressbookPage()
                .editCreatedContact(contactData)
                .updateContactForm(contactData)
                .clickCreateContactButton();
    }

    @AfterEach
    public void removeCreatedContact(){
        AddressbookPage addressbookPage = basePage.switchToAddressbookPage()
                .removeContact(contactData);
    }
}
