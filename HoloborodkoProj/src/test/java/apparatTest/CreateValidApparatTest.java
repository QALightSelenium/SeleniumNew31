package apparatTest;

import org.junit.Test;
import parentTest.ParentTest;

public class CreateValidApparatTest extends ParentTest {

    public CreateValidApparatTest(String browser) {
        super(browser);
    }

    @Test
    public void createApparat(){
        String appNumber = "159";
        String appComment = "cool device";

        //logging in
        loginPage.LoginUser("Student", "909090");

        //verifying that redirected to the correct page
        checkAcceptanceCriteria("Avatar is not present", homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria("Title is not expected", homePage.getTitle(), "Учет запчастей");

        //going to the apparat page
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuApparat();

        //verifying that redirected to the Apparat page

        checkAcceptanceCriteria("Title is not present", apparatPage.isZagolovokPresent(), true);

        //adding new apparat to the list

        apparatPage.clickOnAddButton();
        //verifying that redirected to the Apparat add page
        checkAcceptanceCriteria("Label is not present", apparatPage.isLabelPresent(), true);

        //inputing apparat number and comment
        apparatPage.addNewApparat(appNumber, appComment);

        //verifying that redirected to the Apparat page
        checkAcceptanceCriteria("Title is not present", apparatPage.isZagolovokPresent(), true);
        //verifying that added apparat is present
        checkAcceptanceCriteria("Added apparat is not present",
                apparatPage.isAddedApparatPresent(appNumber,appComment),true);

        //clicking the row with added apparat
        apparatPage.ClickApparatAddedRow();

        //verifying that redirected to the Apparat edit page
        checkAcceptanceCriteria("Page h3 is not present", apparatPage.isApparatEditH3Present(), true);

        //deleting the apparat
        apparatPage.clickApparatDeleteButton();

        //verifying that redirected to the Apparat page
        checkAcceptanceCriteria("Title is not present", apparatPage.isZagolovokPresent(), true);

        //verifying that previously added apparat is deleted
        checkAcceptanceCriteria("Added apparat is not present",
                apparatPage.isAddedApparatPresent(appNumber,appComment),false);

    }
}
