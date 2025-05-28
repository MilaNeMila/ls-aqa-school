package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import model.Contacts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    public static ContactListPage page;

    @BeforeEach
    public void checkingContactOnPages() {
        page = getPage.contactList().goToContactList();
        if (page.checkingContactsOnPage()) {
            page = page.goToCreateContact()
                    .fillContactForm(contactData)
                    .clickCreateContactButton();
        } else {
            contactData = page.getFirstContact();
        }

    }

    @Test
    @DisplayName("Изменение контакта")
    public void testEditContact() {
        Contacts beforeListOfContacts = page.getContactList(); //TODO заменить в классе использование Contacts на ModelList<ContactData>
        int beforeSize = page.sizeOfContactList(beforeListOfContacts);

        page = page.goToContactList()
                .editCreatedContact(contactData)
                .updateContactForm(contactData) //TODO сделать проверку того, что мы потом действительно проверим
                .clickCreateContactButton().goToContactList();

        Contacts afterListOfContacts = page.getContactList();
        int afterSize = page.sizeOfContactList(afterListOfContacts);

        assertThat(afterSize).
                as("Количество элементов не изменилось").
                isEqualTo(beforeSize);

        assertThat(afterListOfContacts)
                .as("Список контактов, исключая измененный, остался прежним")
                .usingRecursiveComparison()
                .ignoringFields("contactMiddleName", "nicknameContactName")
                .isEqualTo(beforeListOfContacts);
    }

    @AfterEach
    public void removeCreatedContact() {
        getPage.contactList().goToContactList().removeContact(contactData);
    }
}