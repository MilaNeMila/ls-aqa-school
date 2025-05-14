package pages.contacts;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import model.ContactData;
import pages.BasePage;
import static com.codeborne.selenide.Selenide.$;
public class CreationContactPage extends BasePage {
    private final SelenideElement firstNameField = $("input[name='firstname']");
    private final SelenideElement middleNameField = $("input[name='middlename']");
    private final SelenideElement lastNameField = $("input[name='lastname']");
    private final SelenideElement nicknameField = $("input[name='nickname']");
    private final SelenideElement createContactButton = $("input[type='submit']");

    public CreationContactPage fillContactForm(ContactData contactData){
        firstNameField.setValue(contactData.contactName);
        middleNameField.setValue(contactData.contactMiddleName);
        lastNameField.setValue(contactData.contactLastName);
        return this;
     }

    public CreationContactPage updateContactForm(ContactData contactData) {
        nicknameField.setValue(contactData.nicknameContactName);
        return this;
    }

    public ContactListPage clickCreateContactButton(){
        createContactButton.click();
        return Selenide.page(ContactListPage.class);
     }

}