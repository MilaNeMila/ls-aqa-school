package ru.ls.qa.school.addressbook.contacts;

import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.contacts.AddressbookPage;
import pages.BasePage;
import ru.ls.qa.school.addressbook.BaseTest;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class RemoveContactTest extends BaseTest {
    private BasePage basePage = new BasePage();
    private AddressbookPage addressbookPage;
    private final ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(faker.name().firstName())
            .contactLastName(faker.name().lastName())
            .nicknameContactName(faker.name().firstName())
            .build();

    @BeforeEach
    public void checkingContactOnPages(){
        addressbookPage = basePage.switchToAddressbookPage();
        if (AddressbookPage.checkingContactsOnPage()){
            basePage.switchToCreatingContactPage()
                    .fillContactForm(contactData)
                    .clickCreateContactButton();
        }
        else {
            contactData.contactName = AddressbookPage.saveCreatedContact(1);
            contactData.contactLastName = AddressbookPage.saveCreatedContact(0);
            }

    }

    @Test
    @DisplayName("Удаление контакта")
    public void testRemoveCreatedContact(){
        step("Удалить найденную запись", () ->{
            addressbookPage.removeContact(contactData.contactName, contactData.contactLastName);
    });
    }

}
