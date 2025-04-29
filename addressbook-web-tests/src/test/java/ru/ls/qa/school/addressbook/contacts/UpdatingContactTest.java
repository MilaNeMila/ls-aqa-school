package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import org.junit.jupiter.api.AfterEach;
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

    @Test
    @DisplayName("Изменение контакта")
    public void testEditContact(){
        AddressbookPage addressbookPage = basePage.switchToCreatingContactPage()
                .fillContactForm(contactData)
                .clickCreateContactButton()
                .switchToAddressbookPage()
                .editCreatedContact(contactData.contactName, contactData.contactLastName)
                .updateContactForm(contactData.nicknameContactName)
                .clickCreateContactButton();
    }

    @AfterEach
    public void removeCreatedContact(){
        AddressbookPage addressbookPage = basePage.switchToAddressbookPage()
                .removeContact(contactData.contactName, contactData.contactLastName);
    }
}
