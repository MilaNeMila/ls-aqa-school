package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class GroupsPage {

    private final ElementsCollection newGroupButton = $$("input[name='new']");
    private final SelenideElement groupNameField = $("input[name='group_name']");
    private final SelenideElement groupHeaderField = $("textarea[name='group_header']");
    private final SelenideElement groupFooterField = $("textarea[name='group_footer']");
    private final SelenideElement createGroupButton = $("input[value='Enter information']");


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
}
