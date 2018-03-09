package apparatTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class CreateValidApparatsWithParam extends ParentTest {
    String number, comment;

    public CreateValidApparatsWithParam(String browser, String number, String comment) {
        super(browser);
        this.number = number;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "123", "best device ever"},
                {"chrome", "777", "woody woodpecker"}
        });
    }

    @Test
    public void addingNewApparats(){
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

        //Adding new apparats
        apparatPage.addNewApparat(number, comment);

        //verifying that redirected to the Apparat page
        checkAcceptanceCriteria("Title is not present", apparatPage.isZagolovokPresent(), true);
        //verifying that added apparat is present
        checkAcceptanceCriteria("Added apparat is not present",
                apparatPage.isAddedApparatPresent(number,comment),true);

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
                apparatPage.isAddedApparatPresent(number,comment),false);


    }

}
