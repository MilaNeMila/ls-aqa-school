import config.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AddressbookPage;
import pages.GroupsPage;
import pages.LoginPage;

public class GroupsTest extends BaseTest {
    private LoginPage loginPage;
    private AddressbookPage addressbookPage;
    private GroupsPage groupsPage;
    @BeforeEach
    public void setGroupsPage(){
        loginPage = new LoginPage();
        addressbookPage = new AddressbookPage();
        groupsPage = new GroupsPage();
    }

    @Test
    public void testCreateNewGroup(){
        loginPage
                .enterUsername("admin")
                .enterPassword("secret")
                .clickLoginButton();
        addressbookPage.switchToGroupsPage();
        groupsPage.createNewGroup()
                .inputGroupNameField("Random Name")
                .inputGroupHeaderField("Another random things")
                .inputGroupFooterField("Comment")
                .clickCreateGroupButton();
    }

}
