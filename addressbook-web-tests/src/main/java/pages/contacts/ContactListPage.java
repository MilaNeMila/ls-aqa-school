package pages.contacts;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.impl.Alias;
import model.ContactData;
import io.qameta.allure;
import pages.BasePage;

import java.util.Optional;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ContactListPage extends BasePage {
    private final ElementsCollection valueInColumn = $$x("//td");
    private final SelenideElement contactDeleteButton = $("input[value='Delete']");
    private static final ElementsCollection listOfContacts = $$("tr[name='entry']");

    public SelenideElement checkValueInColumn(ContactData contactData) {
        return valueInColumn.findBy(text(String.valueOf(contactData.contactName)));
    }

    //TODO добавить @Step
    public ContactListPage removeContact(ContactData contactData) {
        $(String.format("[title='Select (%s %s)']", contactData.contactName, contactData.contactLastName)).click();
        contactDeleteButton.click();
        switchTo().alert()
                  .accept(); // нажать "ок" на алерт, который появляется при удалении контакта; switchTo-- переключение между вкладками
        return this;
    }

    public boolean checkingContactsOnPage() {
        return listOfContacts.isEmpty();
    }

    public ContactData getFirstContact() {

        SelenideElement sourceContact = listOfContacts.first()
                                                      .$("td");

        return ContactData.builder()
                          .id($x("//tr/td[1]").getAttribute("id"))
                          .contactName(sourceContact.sibling(1)
                                                    .getText())
                          .contactLastName(sourceContact.sibling(0)
                                                        .getText())
                          .build();
    }

    public CreationContactPage editCreatedContact(ContactData contactData) throws ElementNotFound {
        ElementsCollection listOfContacts = $$("tr[name='entry']");
        Optional<SelenideElement> contact = listOfContacts.stream()
                                                          .filter(element -> element.find("input[title]")
                                                                                    .getAttribute("title")
                                                                                    .equals(String.format("Select (%s %s)", contactData.contactName, contactData.contactLastName)))
                                                          .findFirst();
        if (contact.isPresent()) {
            contact.get()
                   .find("a[href*='edit.php']")
                   .click();
        } else throw new ElementNotFound(Alias.NONE, "Элемента нет на странице", visible);
        return pages().getCreatingContactPage();
    }

}