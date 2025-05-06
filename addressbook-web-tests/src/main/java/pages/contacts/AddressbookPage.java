package pages.contacts;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import model.ContactData;
import pages.BasePage;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.impl.Alias;

public class AddressbookPage extends BasePage {
    private final ElementsCollection valueInColumn = $$x("//td");
    private final SelenideElement contactDeleteButton = $("input[value='Delete']");
    private static final ElementsCollection listOfContacts = $$("tr[name='entry']");
    public SelenideElement checkValueInColumn(ContactData contactData) {
        return valueInColumn.findBy(text(String.valueOf(contactData.contactName)));
    }

    public AddressbookPage removeContact(ContactData contactData) {
        $(String.format("[title='Select (%s %s)']", contactData.contactName, contactData.contactLastName)).click();
        contactDeleteButton.click();
        switchTo().alert().accept(); // нажать "ок" на алерт, который появляется при удалении контакта; switchTo-- переключение между вкладками
        return this;
    }

    public static boolean checkingContactsOnPage(){
        return listOfContacts.isEmpty();
    }

    public static ContactData saveCreatedContact(ContactData contactData){
        contactData.contactName = listOfContacts.first().$("td").sibling(1).getText();
        contactData.contactLastName = listOfContacts.first().$("td").sibling(0).getText();
        return contactData;
    }

    public CreatingContactPage editCreatedContact(ContactData contactData) throws ElementNotFound {
        ElementsCollection listOfContacts = $$("tr[name='entry']");
        Optional<SelenideElement> contact = listOfContacts.stream().filter(element -> element.find("input[title]")
                .getAttribute("title")
                .equals(String.format("Select (%s %s)", contactData.contactName, contactData.contactLastName))).findFirst();
        if(contact.isPresent()){
           contact.get().find("a[href*='edit.php']").click();
        }
        else throw new ElementNotFound(Alias.NONE, "Элемента нет на странице",visible);
        return new CreatingContactPage();
    }

}