package ru.ls.qa.school.addressbook.contacts;

import com.codeborne.selenide.Selenide;
import model.ContactData;
import model.Contacts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.contacts.ContactListPage;
import ru.ls.qa.school.addressbook.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdatingContactTest extends BaseTest {
    private ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(faker.name().firstName())
            .contactLastName(faker.name().lastName())
            .nicknameContactName(faker.name().firstName())
            .build();

    @BeforeEach
    public void checkingContactOnPages() {
        ContactListPage contactListPage = getPage.contactList().goToContactList();
        if (contactListPage.checkingContactsOnPage()) {
            getPage.contactList().goToCreateContact()
                    .fillContactForm(contactData)
                    .clickCreateContactButton();
        } else {
            contactData = contactListPage.getFirstContact();
        }

    }

    @Test
    @DisplayName("Изменение контакта")
    public void testEditContact() {
        Contacts beforeListOfContacts = getPage.contactList().getContactList();
        int beforeSize = getPage.contactList().sizeOfContactList(beforeListOfContacts);

        ContactListPage contactListPage = getPage.contactList().goToContactList()
                .editCreatedContact(contactData)
                .updateContactForm(contactData)
                .clickCreateContactButton().goToContactList();
        Contacts afterListOfContacts = getPage.contactList().getContactList();
        int afterSize = getPage.contactList().sizeOfContactList(afterListOfContacts);

        assertThat(afterSize).
                as("Количество элементов не изменилось").
                isEqualTo(beforeSize);

        assertThat(afterListOfContacts.without(contactData))
                .as("Список контактов, исключая измененный, остался прежним")
                .usingRecursiveComparison()
                .ignoringFields("contactMiddleName", "nicknameContactName")
                .isEqualTo(beforeListOfContacts.without(contactData));
    }

    @AfterEach
    public void removeCreatedContact() {
        getPage.contactList().goToContactList().removeContact(contactData);
    }
}
