package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.contacts.AddressbookPage;
import ru.ls.qa.school.addressbook.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class CreatingNewContactTest extends BaseTest {
    private BasePage basePage = new BasePage();
    private final ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(faker.name().firstName())
            .contactLastName(faker.name().lastName())
            .nicknameContactName(faker.name().firstName())
            .build();

    @Test
    @DisplayName("Создание контакта")
    public void testCreateNewContact(){
        AddressbookPage addressbookPage = basePage.switchToCreatingContactPage()
                .fillContactForm(contactData)
                .clickCreateContactButton()
                .switchToAddressbookPage();
        addressbookPage.checkValueInColumn(contactData).shouldBe(visible);
    }

    @AfterEach
    public void removeCreatedContact(){
        AddressbookPage addressbookPage = basePage.switchToAddressbookPage()
                .removeContact(contactData);
    }
}
