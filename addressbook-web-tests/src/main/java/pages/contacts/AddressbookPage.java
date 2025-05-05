package pages.contacts;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
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
    ElementsCollection listOfContacts = $$("tr[name='entry']");
    public SelenideElement checkValueInColumn(String contactName) {
        return valueInColumn.findBy(text(contactName));
    }

    public AddressbookPage removeContact(String firstName, String lastName) {
        $(String.format("[title='Select (%s %s)']", firstName, lastName)).click();
        contactDeleteButton.click();
        switchTo().alert().accept(); // нажать "ок" на алерт, который появляется при удалении контакта; switchTo-- переключение между вкладками
        return this;
    }

    public static boolean checkingContactsOnPage(){
        if($$("tr[name='entry']").isEmpty()){
            return true;
        }
        else return false;
    }

    public static String saveCreatedContact(int index){
        return $$("tr[name='entry']")
                .first().$("td").sibling(index).getText();
    }

    public CreatingContactPage editCreatedContact(String firstName, String lastName) throws ElementNotFound {
        ElementsCollection listOfContacts = $$("tr[name='entry']");
        Optional<SelenideElement> contact = listOfContacts.stream().filter(element -> element.find("input[title]")
                .getAttribute("title")
                .equals(String.format("Select (%s %s)", firstName, lastName))).findFirst();
        if(contact.isPresent()){
           contact.get().find("a[href*='edit.php']").click();
        }
        else throw new ElementNotFound(Alias.NONE, "Элемента нет на странице",visible);
        return new CreatingContactPage();
    }

}