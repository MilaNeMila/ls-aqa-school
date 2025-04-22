package pages.contacts;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
public class AddressbookPage extends BasePage {
    private final ElementsCollection valueInColumn = $$x("//td");
    private final SelenideElement contactDeleteButton = $("input[value='Delete']");
    public SelenideElement checkValueInColumn(String contactName) {
        return valueInColumn.findBy(text(contactName));
    }
    public AddressbookPage removeContact(String firstName, String lastName){
        $(String.format("[title='Select (%s %s)']", firstName, lastName)).click();
        contactDeleteButton.click();
        return this;
    }
}