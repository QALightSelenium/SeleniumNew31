package aparattest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value= Parameterized.class)


/**
 * I have understood only numbers can be inputted in the AparantNumber field
 */
public class InvalidAddAparatWithParametrs extends ParentTest{

    private String aparatNumber,
           aparatComment;
    private boolean flag = false;
    private int rows;

    public InvalidAddAparatWithParametrs(String browser, String aparatNumber, String aparatComment){

        super(browser);
        this.aparatNumber = aparatNumber;
        this.aparatComment = aparatComment;
    }

    @Parameterized.Parameters
    public static Collection testDData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "Hi", "AparComment"},
                {"chrome", "Hi5", "AparatComment"},
                {"chrome", "546", "AparC"}
        });

    }

    @Test
    public void invalidAddAparat() throws IOException {

        loginPage.loginUser("Student", "909090");
            Assert.assertEquals("Учет запчастей" ,homePage.driver.getTitle());
        homePage.openSlovariList();
            Assert.assertEquals(true, homePage.isAvatarPresent());
        homePage.openAparatPage();
            aparatPage.checkZagolovok("Аппарат Список");

                rows = aparatPage.rowsOnThePage();
        aparatPage.openSlovaryPage();
            slovaryPage.checkZagolovok("Словарь");
        slovaryPage.inputAparatNumber(aparatNumber);
        slovaryPage.inputAparatComment(aparatComment);
        slovaryPage.creteAparat();
            aparatPage.checkZagolovok("Аппарат Список");


            flag= rows == aparatPage.rowsOnThePage()? true : false;

            checkAcceptanceCriteria("Aparat was added!!!!!!!!!", true, flag);
    }

}
