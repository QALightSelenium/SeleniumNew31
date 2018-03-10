package logintests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.ParentPage;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value= Parameterized.class)

public class InvalidLoginWithParametrs extends ParentTest {
    String login, pass;

    public InvalidLoginWithParametrs(String browser, String login, String pass){
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testDData(){
        return Arrays.asList(new Object[][]{
            {"chrome","Student","906190"},
            {"chrome","Studen","909090"}
        });
    }

    @Test
    public void invalidLogin() throws IOException {
        loginPage.loginUser(login, pass);
        checkAcceptanceCriteria("Title is not match", loginPage.getTitle(), "Account of spare:Авторизация");

    }
}
