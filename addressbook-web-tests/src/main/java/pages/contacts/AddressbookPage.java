package pages.contacts;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import pages.BasePage;

import java.util.Optional;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.impl.Alias;

public class AddressbookPage extends BasePage {
    private final ElementsCollection valueInColumn = $$x("//td");
    private final SelenideElement contactDeleteButton = $("input[value='Delete']");

    public SelenideElement checkValueInColumn(String contactName) {
        return valueInColumn.findBy(text(contactName));
    }

    public AddressbookPage removeContact(String firstName, String lastName) {
        $(String.format("[title='Select (%s %s)']", firstName, lastName)).click();
        contactDeleteButton.click();
        return this;
    }

    public CreatingContactPage editCreatedContact(String firstName, String lastName) throws ElementNotFound {
        ElementsCollection listOfContacts = $$("tr[name='entry']");
        Optional<SelenideElement> test = listOfContacts.stream().filter(element -> element.find("input[title]")
                .getAttribute("title")
                .equals(String.format("Select (%s %s)", firstName, lastName))).findFirst();
        if(test.isPresent()){
           test.get().find("a[href*='edit.php']").click();
        }
        else throw new ElementNotFound(Alias.NONE, "Элемента нет на странице",visible);
        return new CreatingContactPage();
    }

}