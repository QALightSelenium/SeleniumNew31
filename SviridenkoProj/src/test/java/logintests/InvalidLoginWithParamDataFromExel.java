package loginTests;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * параметерезований тест вичиту даних з екселю
 */
public class InvalidLoginWithParamDataFromExel extends ParentTest {
    String login, pass;

    public InvalidLoginWithParamDataFromExel(String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
    }


    @Parameterized.Parameters       //скильки разів зчитав конструтор стільки разів йде присвоєння в конструкторі
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }



    @Test
    public void invalidLogin() throws IOException {
        loginPage.loginUser(login,pass);
        checkAcceptanceCriteria("Title not match", loginPage.getTitle(), "Account of spare:Авторизация");
    }
}
