package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SlovarPage extends ParentPage {

    public SlovarPage(WebDriver driver){

        super(driver);

    }

    int numberForApparatComment = 0;
    String AparatNumber = "1" + ++numberForApparatComment;

    String AparatCommet = "АпаратНейм" + numberForApparatComment;

    String tableLocator = "//table[@id='device_list']//td[contains(text(),'"+ "АпаратНейм" + numberForApparatComment +"')]";

    @FindBy(id = "apparat_apparatNumber")
    WebElement AparatField;

    @FindBy(id = "apparat_apparatComment")
    WebElement ApparatCommentField;

    @FindBy(xpath = "//button[@name='add']")
    WebElement SozdatButton;

    @FindBy(xpath = "//button[@name='delete']")
    WebElement UdalitButton;

    @FindBy(tagName="h3")
    WebElement SubZagolovok;

    @FindBy(xpath = "//button[@name='save']")
    WebElement sohranitButton;


    /**
     * add Number
     * @param aparatNumber
     */
    public void inputAparatNumber(String aparatNumber){

        actionsWithWebElements.inputValueField(AparatField ,aparatNumber);

    }

    /**
     * Add comment
     * @param aparatComment
     */
    public void inputAparatComment(String aparatComment) {

        actionsWithWebElements.inputValueField(ApparatCommentField, aparatComment);

    }

    /**
     * Crete aparat
     */
    public void creteAparat(){

        actionsWithWebElements.buttonClick(SozdatButton);

    }

    public void clickUdalitButton(){

        actionsWithWebElements.buttonClick(UdalitButton);

    }

    public void clickOnSohranitButton(){

        actionsWithWebElements.buttonClick(sohranitButton);

    }

    public void checkZagolovokOfCertainAparat(String zagolovokText){

        Assert.assertEquals("zagolovok is not matched", SubZagolovok.getText(), zagolovokText);

    }

    public String getValueFromNumberField(){

        return AparatField.getAttribute("value");

    }
    public String getValueFromCommntField(){


        return ApparatCommentField.getAttribute("value");

    }
}
