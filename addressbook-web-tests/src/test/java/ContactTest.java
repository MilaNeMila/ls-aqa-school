import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.contacts.AddressbookPage;
import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;

public class ContactTest extends BaseTest{
    private BasePage basePage = new BasePage();
    private final ContactData contactData = ContactData.builder()
            .contactName(faker.name().firstName())
            .contactMiddleName(faker.name().firstName())
            .contactLastName(faker.name().lastName())
            .build();

    @Test
    @DisplayName("Создание контакта")
    public void testCreateNewContact(){
        AddressbookPage addressbookPage = basePage.switchToCreatingContactPage()
                .fillContactForm(contactData)
                .clickCreateContactButton()
                .switchToAddressbookPage();
        addressbookPage.checkValueInColumn(contactData.contactName).shouldBe(visible);
    }
    @AfterEach
    public void removeCreatedContact(){
        AddressbookPage addressbookPage = basePage.switchToAddressbookPage()
                .removeContact(contactData.contactName, contactData.contactLastName);
    }

}
