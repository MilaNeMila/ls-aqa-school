package pages.groups;
import com.codeborne.selenide.SelenideElement;
import model.GroupData;
import static com.codeborne.selenide.Selenide.$;
public class CreatingGroupPage extends GroupsPage {
    private final SelenideElement groupNameField = $("input[name='group_name']");
    private final SelenideElement groupHeaderField = $("textarea[name='group_header']");
    private final SelenideElement groupFooterField = $("textarea[name='group_footer']");
    private final SelenideElement createGroupButton = $("input[value='Enter information']");
    public CreatingGroupPage clickCreateGroupButton(){
        createGroupButton.click();
        return this;
    }
    public CreatingGroupPage fillGroupForm(GroupData groupData){
        groupNameField.setValue(groupData.groupName);
        groupHeaderField.setValue(groupData.groupHeader);
        groupFooterField.setValue(groupData.groupFooter);
        return this;
    }
}
