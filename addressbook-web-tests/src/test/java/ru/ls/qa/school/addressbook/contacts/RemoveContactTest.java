package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.contacts.ContactListPage;
import ru.ls.qa.school.addressbook.BaseTest;

public class RemoveContactTest extends BaseTest {
    private ContactListPage contactListPage;

    private final ContactData contactData = ContactData.builder()
                                                       .contactName(faker.name()
                                                                         .firstName())
                                                       .contactMiddleName(faker.name()
                                                                               .firstName())
                                                       .contactLastName(faker.name()
                                                                             .lastName())
                                                       .nicknameContactName(faker.name()
                                                                                 .firstName())
                                                       .build();

    @BeforeEach
    public void checkingContactOnPages() {
        contactListPage = getPage.contactList();
        if (contactListPage.checkingContactsOnPage()) {
            contactListPage = contactListPage.goToCreateContact()
                                             .fillContactForm(contactData)
                                             .clickCreateContactButton();
        }
    }

    @Test
    @DisplayName("�������� ��������")
    public void testRemoveCreatedContact() {

        //TODO Забирать данные до действий теста (список контактов)

        ContactData contact = contactListPage.getFirstContact();
        contactListPage.removeContact(contactData);

        //TODO Забирать данные после прохождения теста (список контактов)

        //TODO Проверки списков
    }

}
