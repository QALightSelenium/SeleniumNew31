package apparatTest;

import org.junit.Test;
import parentTest.ParentTest;

public class CreateApparatTest extends ParentTest {

    public CreateApparatTest(String browser) {
        super(browser);
    }

    @Test
    public void createApparat(){
        loginPage.LoginUser("Student", "909090");
        checkAcceptanceCriteria("Avatar is not present", homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria("Title is not expected", homePage.getTitle(), "Учет запчастей");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuApparat();
        checkAcceptanceCriteria("Avatar is not present", apparatPage.isTitlePresent(), true);
        checkAcceptanceCriteria("Title is not expected", apparatPage.getTitle(), "Учет запчастей");
        apparatPage.clickOnAddButton();




    }
}
