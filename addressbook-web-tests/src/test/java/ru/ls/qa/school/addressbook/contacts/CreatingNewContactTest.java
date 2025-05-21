package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.contacts.ContactListPage;
import ru.ls.qa.school.addressbook.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class CreatingNewContactTest extends BaseTest {
    private final ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(faker.name().firstName())
            .contactLastName(faker.name().lastName())
            .nicknameContactName(faker.name().firstName())
            .build();

    @Test
    @DisplayName("Создание нового контакта")
    public void testCreateNewContact() {
        ContactListPage contactListPage = getPage.contactList().goToCreateContact()
                .fillContactForm(contactData)
                .clickCreateContactButton()
                .goToContactList();
        contactListPage.checkValueInColumn(contactData).shouldBe(visible);
    }

    @AfterEach
    public void removeCreatedContact() {
        ContactListPage contactListPage = getPage.contactList().goToContactList()
                .removeContact(contactData);
    }
}
