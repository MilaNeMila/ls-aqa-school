package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import model.Contacts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.contacts.ContactListPage;
import ru.ls.qa.school.addressbook.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

public class CreatingNewContactTest extends BaseTest {
    private final ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(null)
            .contactLastName(faker.name().lastName())
            .nicknameContactName(null)
            .build();

    @Test
    @DisplayName("Создание нового контакта")
    public void testCreateNewContact() {
        Contacts beforeListOfContacts = getPage.contactList().getContactList();
        int beforeSize = getPage.contactList().sizeOfContactList(beforeListOfContacts);

        ContactListPage contactListPage = getPage.contactList().goToCreateContact()
                .fillContactForm(contactData)
                .clickCreateContactButton()
                .goToContactList();

        Contacts afterListOfContacts = getPage.contactList().getContactList();
        int afterSize = getPage.contactList().sizeOfContactList(afterListOfContacts);

        assertThat(afterSize).
                as("Количество элементов увеличилось на 1").
                isEqualTo(beforeSize + 1);

        assertThat(afterListOfContacts)
                .as("Созданные контакты не изменились")
                .usingRecursiveComparison()
                .ignoringFields("contactMiddleName", "nicknameContactName")
                .isEqualTo(beforeListOfContacts.withAdd(contactData));
    }

   // @AfterEach
    public void removeCreatedContact() {
        ContactListPage contactListPage = getPage.contactList().goToContactList()
                .removeContact(contactData);
    }
}
