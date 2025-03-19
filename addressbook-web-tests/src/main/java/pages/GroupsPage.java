package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import model.GroupData;
import org.openqa.selenium.By;
import tools.RandomTools;

import static com.codeborne.selenide.Selenide.*;


public class GroupsPage {
    private RandomTools randomTools = new RandomTools();

    private final ElementsCollection newGroupButton = $$("input[name='new']"),
            deleteGroupButton = $$("input[name='delete']"),
            nameOfNewGroup = $$(".group");
    private final SelenideElement groupNameField = $("input[name='group_name']"),
            groupHeaderField = $("textarea[name='group_header']"),
            groupFooterField = $("textarea[name='group_footer']"),
            createGroupButton = $("input[value='Enter information']"),
            successfulCreatingText = $(".msgbox"),
            groupPageLink = $x("//a[text() = 'group page']"),
            groupChechboxedList = $("input[title='Select (Articuno)']");

    @Step()
    public GroupsPage createNewGroup(){
        newGroupButton.first().click();
        return this;
    }

    public GroupsPage setGroupNameField(String group_name){
        groupNameField.setValue(group_name);
        return this;
    }

    public GroupsPage setGroupHeaderField(String group_header){
        groupHeaderField.setValue(group_header);
        return this;
    }

    public GroupsPage setGroupFooterField(String groupFooter){
        groupFooterField.setValue(groupFooter);
        return this;
    }

    public GroupsPage clickCreateGroupButton(){
        createGroupButton.click();
        return this;
    }

    public GroupsPage clickGroupPageLink(){
        groupPageLink.click();
        return this;
    }

    public GroupsPage chooseCreatedGroup(GroupData groupData){
        By locator = By.cssSelector(String.format("input[title='Select ('%s')']", groupData.getGroupName()));
        $(locator).click();
        return this;
    }
}
