import config.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AddressbookPage;
import pages.GroupsPage;
import pages.LoginPage;
import tools.RandomTools;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupsTest extends BaseTest {
    private LoginPage loginPage;
    private AddressbookPage addressbookPage;
    private GroupsPage groupsPage;
    private RandomTools randomTools;
    @BeforeEach
    public void setGroupsPage(){
        loginPage = new LoginPage();
        addressbookPage = new AddressbookPage();
        groupsPage = new GroupsPage();
        randomTools = new RandomTools();
        loginPage
                .enterUsername("admin")
                .enterPassword("secret")
                .clickLoginButton();
    }

    @Test
    public void testCreateNewGroup(){
        addressbookPage.switchToGroupsPage();
        groupsPage.createNewGroup()
                .setGroupNameField(randomTools.groupName)
                .setGroupHeaderField(randomTools.randomHeader)
                .setGroupFooterField(randomTools.randomFooter)
                .clickCreateGroupButton()
                .clickGroupPageLink()
                .chooseCreatedGroup();
    }

    @Test
    public void test(){
        addressbookPage.switchToGroupsPage();
        groupsPage.chooseCreatedGroup();
    }


}
