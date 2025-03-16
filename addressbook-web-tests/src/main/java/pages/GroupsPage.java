package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class GroupsPage {

    private final ElementsCollection newGroupButton = $$("input[name='new']");
    private final SelenideElement groupNameField = $("input[name='group_name']");
    private final SelenideElement groupHeaderField = $("textarea[name='group_header']");
    private final SelenideElement groupFooterField = $("textarea[name='group_footer']");
    private final SelenideElement createGroupButton = $("input[value='Enter information']");
    private final SelenideElement successfulCreatingText = $(".msgbox");
    private final SelenideElement groupPageLink = $x("//a[text() = 'group page']");
    private final ElementsCollection nameOfNewGroup = $$(".group");


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

    public GroupsPage testText(){
        for(SelenideElement i: nameOfNewGroup){
            System.out.println(i.getText());
        }
        return this;
    }

    public String getsuccessfulCreatingText(){
        return successfulCreatingText.getText();
    }
}
