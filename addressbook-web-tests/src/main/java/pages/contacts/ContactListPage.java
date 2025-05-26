package pages.contacts;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.impl.Alias;
import io.qameta.allure.Step;
import model.ContactData;
import model.Contacts;
import pages.BasePage;

import java.util.Optional;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ContactListPage extends BasePage {
    private final ElementsCollection valueInColumn = $$x("//td");
    private final SelenideElement contactDeleteButton = $("input[value='Delete']");
    private static final ElementsCollection listOfContacts = $$("tr[name='entry']");

    @Step("ѕоиск контакта")
    public SelenideElement checkValueInColumn(ContactData contactData) {
        return valueInColumn.findBy(text(String.valueOf(contactData.contactName)));
    }

    @Step("”даление контакта")
    public ContactListPage removeContact(ContactData contactData) {
        $(String.format("[title='Select (%s %s)']", contactData.contactName, contactData.contactLastName)).click();
        contactDeleteButton.click();
        switchTo().alert()
                .accept(); // нажать "ок" на алерт, который по€вл€етс€ при удалении контакта; switchTo-- переключение между вкладками
        return this;
    }

    @Step("ѕроверка списка контактов на странице")
    public boolean checkingContactsOnPage() {
        return listOfContacts.isEmpty();
    }

    @Step("ѕолучение первого контактна из списка")
    public ContactData getFirstContact() {
        SelenideElement sourceContact = listOfContacts.first()
                .$("td");
        return ContactData.builder()
                .contactName(sourceContact.sibling(1)
                        .getText())
                .contactLastName(sourceContact.sibling(0)
                        .getText())
                .build();
    }

    @Step
    public Optional<SelenideElement> findAnElement(ContactData contactData) {
        return listOfContacts.stream()
                .filter(element -> element.find("input[title]")
                        .getAttribute("title")
                        .equals(String.format("Select (%s %s)", contactData.contactName, contactData.contactLastName)))
                .findFirst();
    }


    @Step("»зменение контактна")
    public CreationContactPage editCreatedContact(ContactData contactData) throws ElementNotFound {
        if (findAnElement(contactData).isPresent()) {
            findAnElement(contactData).get()
                    .find("a[href*='edit.php']")
                    .click();
        } else throw new ElementNotFound(Alias.NONE, "Ёлемента нет на странице", visible);
        return pages().getCreatingContactPage();
    }

    @Step("‘ормирование списка контактов")
    public Contacts getContactList() {
        Contacts contacts = new Contacts();
        for (SelenideElement element : listOfContacts) {
            int id = Integer.parseInt(element.$("td").$("input").getAttribute("id")); //все ок
            String contactName = element.$("td").sibling(1)
                    .getText();
            String contactLastName = element.$("td").sibling(0)
                    .getText();
            ContactData contactData = new ContactData(contactName, null, contactLastName, null);
            //contactData.setId(id);
            contacts.add(contactData);
        }
        return contacts;
    }

    @Step("ѕолучить количество элементов на странице")
    public int sizeOfContactList(Contacts contacts) {
        return contacts.size();
    }

}