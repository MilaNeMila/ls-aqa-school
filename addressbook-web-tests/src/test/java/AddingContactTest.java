import org.junit.jupiter.api.BeforeEach;
import pages.AddressbookPage;
import pages.GroupsPage;
import pages.LoginPage;
import tools.RandomTools;

public class AddingContactTest {
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

}
