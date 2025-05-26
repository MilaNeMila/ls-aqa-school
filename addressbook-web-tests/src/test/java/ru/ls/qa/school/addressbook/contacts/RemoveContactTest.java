package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import model.Contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.contacts.ContactListPage;
import ru.ls.qa.school.addressbook.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveContactTest extends BaseTest {
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
    @DisplayName("Удаление контакта")
    public void testRemoveCreatedContact() {
        Contacts beforeListOfContacts = getPage.contactList().getContactList();
        int beforeSize = getPage.contactList().sizeOfContactList(beforeListOfContacts);

        ContactListPage contactListPage = getPage.contactList().goToContactList()
                .removeContact(contactData)
                .goToContactList();

        Contacts afterListOfContacts = getPage.contactList().getContactList();
        int afterSize = getPage.contactList().sizeOfContactList(afterListOfContacts);

        assertThat(afterSize).
                as("Количество элементов уменьшилось на 1").
                isEqualTo(beforeSize - 1);

        assertThat(afterListOfContacts)
                .as("Не изменилось")
                .usingRecursiveComparison()
                .ignoringFields("contactMiddleName", "nicknameContactName")
                .isEqualTo(beforeListOfContacts.without(contactData));

    }

}
