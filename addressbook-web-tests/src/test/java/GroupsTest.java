import com.github.javafaker.Faker;
import model.GroupData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AddressbookPage;
import pages.GroupsPage;
import pages.LoginPage;

public class GroupsTest extends BaseTest {
    private LoginPage loginPage;
    private AddressbookPage addressbookPage;
    private final Faker faker = new Faker();
    private final GroupData group = GroupData.builder()
                                             .groupName(faker.name().firstName())
                                             .groupAuthor(faker.name().lastName())
                                             .groupDescription(faker.address().fullAddress())
                                             .build();
    @BeforeEach
    public void setGroupsPage(){
        loginPage = new LoginPage();
        addressbookPage = new AddressbookPage();
        loginPage
                .enterUsername("admin")
                .enterPassword("secret")
                .clickLoginButton();
    }

    @Test
    @DisplayName("sdasd")
    public void testCreateNewGroup(){
        GroupsPage groupsPage = addressbookPage.switchToGroupsPage()
                                               .createNewGroup()
                                               .fillGroupForm(group)
                                               .clickCreateGroupButton()
                                               .clickGroupPageLink()
                                               .chooseCreatedGroup();

        groupsPage.checkGroupPage();
    }

    @Test
    public void test(){
        addressbookPage.switchToGroupsPage()
                       .chooseCreatedGroup(group);
    }
}
