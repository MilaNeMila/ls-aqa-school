import com.github.javafaker.Faker;
import model.GroupData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AddressbookPage;
import pages.GroupsPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;


public class GroupsTest extends BaseTest {
    private LoginPage loginPage;
    private AddressbookPage addressbookPage;
    private final Faker faker = new Faker();
    private final GroupData groupData = GroupData.builder()
            .groupName(faker.name().firstName())
            .groupFooter(faker.name().lastName())
            .groupHeader(faker.address().fullAddress())
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
    @DisplayName("Создание группы")
    public void testCreateNewGroup(){
        GroupsPage groupsPage = addressbookPage.switchToGroupsPage()
                                               .createNewGroup()
                                               .fillGroupForm(groupData)
                                               .clickCreateGroupButton()
                                               .clickGroupPageLink();
        groupsPage.chooseCreatedGroup(groupData.groupName).shouldBe(visible);
    }

    @AfterEach
    public void removeCreatedGroup(){
        GroupsPage groupsPage = addressbookPage.switchToGroupsPage()
                .removeCreatedGroup(groupData.groupName);
    }
}
