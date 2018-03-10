package pages;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AparatPage extends ParentPage {

    public AparatPage(WebDriver driver){
        super(driver);
    }

    List<WebElement> rows;

    @FindBy(xpath = "//section[@class='content-header']//h1")
    WebElement Aparatheader;

    @FindBy(xpath = "//div[@class='box-tools']/a[@class='btn btn-info btn-sm']")
    WebElement AddButton;

    @FindBy(xpath = "//tbody/tr")
    WebElement TableRow;

    By rowTable = By.xpath("//tbody/tr");




    public void openSlovaryPage(){

        actionsWithWebElements.buttonClick(AddButton);

    }

    public int rowsOnThePage(){

        try {
            rows =  driver.findElements(rowTable);
            int countRows = rows.size();

            return countRows;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }

    }



    public void openFirstElemetFromList(){

            rows =  (driver.findElements(rowTable));

            if(!rows.isEmpty()) {
                actionsWithWebElements.buttonClick(rows.get(0));
            }else{
                Assert.fail("No aparants in the list");
            }

    }


    /**
     * Method verify before values and afters values in a table row
     * @param aparatNumberBefore
     * @param aparatCommentBefore
     * @param aparatNumberAfter
     * @param aparatCommentAfter
     * @return
     */
    public boolean compareBeforeAfterElementInTable(String aparatNumberBefore, String aparatCommentBefore ,String aparatNumberAfter, String aparatCommentAfter){
        By dynamicAparatXpath = null;
        By dynamicAparatCommentXpath = null;

        try {
            dynamicAparatXpath = By.xpath("//td[contains(text(),'+" + aparatNumberAfter +"')]");
            dynamicAparatCommentXpath = By.xpath("//td[contains(text(),'+" + aparatCommentAfter +"')]");

            if(!(aparatNumberBefore.equals(aparatNumberAfter) && aparatCommentBefore.equals(aparatCommentAfter))){
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }











}
