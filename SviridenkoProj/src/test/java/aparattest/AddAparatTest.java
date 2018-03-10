package aparattest;

import org.junit.Assert;
import org.junit.Test;
import pages.SlovarPage;
import parentTest.ParentTest;

import java.io.IOException;

public class AddAparatTest extends ParentTest{

    public AddAparatTest(String browser){
        super(browser);

    }

    private int rows;



    @Test
    public void createAparat() throws IOException{

        loginPage.loginUser("Student", "909090");
            Assert.assertEquals("Учет запчастей" ,homePage.driver.getTitle());
                log.info("HomePage is opened");

        homePage.openSlovariList();
            Assert.assertEquals(true, homePage.isAvatarPresent());
                log.info("List is opened");
        homePage.openAparatPage();
            aparatPage.checkZagolovok("Аппарат Список");
                log.info("Aparat page is opened");

                rows = aparatPage.rowsOnThePage() + 1;

        aparatPage.openSlovaryPage();
            slovaryPage.checkZagolovok("Словарь");
                log.info("Slovari page is opened");

        slovaryPage.inputAparatNumber("578");
        slovaryPage.inputAparatComment("Hello my world");
        slovaryPage.creteAparat();

            aparatPage.checkZagolovok("Аппарат Список");
                Assert.assertEquals(rows ,aparatPage.rowsOnThePage());
                    log.info("Aparat is added to list");
    }

}
