package logintests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class ValidLoginWithParamFromExel extends ParentTest {

    public ValidLoginWithParamFromExel(String browser){

        super(browser);

    }

    @Test
    public void validLogin() throws IOException{

        Map dataFromExelForValidLoginTest = excelDriver.getData(ConfigData.getCfgValue("DATA_FILE"), "validLogOn");  //має значеня зчитані з файла xsl
        loginPage.OpenLoginPage();
        loginPage.inputLoginName(dataFromExelForValidLoginTest.get("login").toString());
        loginPage.inputPasswordId(dataFromExelForValidLoginTest.get("pass").toString());
        loginPage.clickSubmitButton();
        checkAcceptanceCriteria("Avatar is not present", homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria("Title is not expected", homePage.getTitle(), "Учет запчастей");
    }
}
