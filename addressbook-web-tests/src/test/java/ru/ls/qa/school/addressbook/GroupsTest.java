package ru.ls.qa.school.addressbook;

import model.GroupData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.groups.GroupsPage;
import ru.ls.qa.school.addressbook.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class GroupsTest extends BaseTest {
    private final BasePage basePage = new BasePage();
    private final GroupData groupData = GroupData.builder()
            .groupName(faker.name().firstName())
            .groupFooter(faker.name().lastName())
            .groupHeader(faker.address().fullAddress())
            .build();

    @Test
    @DisplayName("Создание группы")
    public void testCreateNewGroup(){
        GroupsPage groupsPage = basePage.switchToGroupsPage()
                                               .createNewGroup()
                                               .fillGroupForm(groupData)
                                               .clickCreateGroupButton()
                                               .clickGroupPageLink();
        groupsPage.chooseCreatedGroup(groupData.groupName).shouldBe(visible);
    }

    @AfterEach
    public void removeCreatedGroup(){
        GroupsPage groupsPage = basePage.switchToGroupsPage()
                .removeCreatedGroup(groupData.groupName);
    }
}
