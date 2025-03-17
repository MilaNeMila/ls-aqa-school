package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tools.RandomTools;

import static com.codeborne.selenide.Selenide.*;


public class GroupsPage {
    private RandomTools randomTools = new RandomTools();

    private final ElementsCollection newGroupButton = $$("input[name='new']");
    private final ElementsCollection deleteGroupButton = $$("input[name='delete']");
    private final SelenideElement groupNameField = $("input[name='group_name']");
    private final SelenideElement groupHeaderField = $("textarea[name='group_header']");
    private final SelenideElement groupFooterField = $("textarea[name='group_footer']");
    private final SelenideElement createGroupButton = $("input[value='Enter information']");
    private final SelenideElement successfulCreatingText = $(".msgbox");
    private final SelenideElement groupPageLink = $x("//a[text() = 'group page']");
    private final ElementsCollection nameOfNewGroup = $$(".group");
    private final SelenideElement groupChechboxedList = $("input[title='Select (Articuno)']");


    public GroupsPage createNewGroup(){
        newGroupButton.first().click();
        return this;
    }

    public GroupsPage inputGroupNameField(String group_name){
        groupNameField.setValue(group_name);
        return this;
    }
    public GroupsPage inputGroupHeaderField(String group_header){
        groupHeaderField.setValue(group_header);
        return this;
    }
    public GroupsPage inputGroupFooterField(String group_footer){
        groupFooterField.setValue(group_footer);
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

    public GroupsPage chooseCreatedGroup(){
        findGroup().click();
        return this;
    }

    private SelenideElement findGroup(){
        return $("input[title='Select ('"+randomTools.groupName+"')']");
    }

}
