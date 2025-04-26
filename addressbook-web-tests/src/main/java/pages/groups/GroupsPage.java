package pages.groups;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;
import static com.codeborne.selenide.Selenide.*;

public class GroupsPage extends BasePage {

    private final ElementsCollection newGroupButton = $$("input[name='new']");
    private final ElementsCollection deleteGroupButton = $$("input[name='delete']");
    private final SelenideElement groupPageLink = $x("//a[text() = 'group page']");


    public CreatingGroupPage createNewGroup(){
        newGroupButton.first().click();
        return new CreatingGroupPage();
    }

    public GroupsPage clickGroupPageLink(){
        groupPageLink.click();
        return this;
    }

    public GroupsPage removeCreatedGroup(String groupName){
        chooseCreatedGroup(groupName).click();
        deleteGroupButton.first().click();
        return this;
    }

    public SelenideElement chooseCreatedGroup(String groupName){
        return $(String.format("[title='Select (%s)']", groupName));
    }
}
