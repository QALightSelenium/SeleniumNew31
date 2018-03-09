package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparatPage extends ParentPage {

    @FindBy(xpath = "//*[@class='content-header']//h1")
    WebElement ApparatPageTitle;
    @FindBy(xpath = "//a[@data-original-title='Add']")
    WebElement AddApparatButton;
    @FindBy(id = "apparat_apparatNumber")
    WebElement ApparatNumber;
    @FindBy(id = "apparat_apparatComment")
    WebElement ApparatComment;
    @FindBy(xpath = "//button[@name='add']")
    WebElement ApparatCreateButton;
    @FindBy(xpath = "//table[@id='device_list']//tbody/tr[last()]")
    WebElement ApparatLastRow;
    @FindBy(xpath = "//tbody/tr[last()]/td[1]")
    WebElement ApparatLastRowNum;
    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    WebElement ApparatLastRowCom;
    @FindBy(xpath = "//button[@name='delete']")
    WebElement ApparatDeleteButton;
    @FindBy(xpath = "//h3[contains(.,'Редактирование')]")
    WebElement ApparatEditH3;
    @FindBy(xpath = "//h1[contains(.,'Аппарат')]")
    WebElement ApparatPageZagolovok;


    public ApparatPage(WebDriver driver) {
        super(driver);
    }

    public boolean isZagolovokPresent(){
        return actionsWithWebElements.isElementPresent(ApparatPageZagolovok);
    }

    public void clickOnAddButton() { actionsWithWebElements.ClickElement(AddApparatButton);}

    public boolean isLabelPresent() {
        return actionsWithWebElements.isElementPresent(ApparatNumber);
    }

    public  String getCurrentUrl(){return driver.getCurrentUrl();}

    public void InputApparatNumber(String appNumber){
        actionsWithWebElements.InputToTextField(ApparatNumber, appNumber);
    }

    public void InputApparatComment(String appComment){
        actionsWithWebElements.InputToTextField(ApparatComment, appComment);
    }

    public void ClickApparatCreateButton(){
        actionsWithWebElements.ClickElement(ApparatCreateButton);
    }

    public void ClickApparatAddedRow(){
        actionsWithWebElements.ClickElement(ApparatLastRowNum);
    }

    public boolean isApparatEditH3Present() {
        return actionsWithWebElements.isElementPresent(ApparatEditH3);
    }

    public boolean isAddedApparatPresent(String num, String com) {
        return actionsWithWebElements.areTwoElementPresent(ApparatLastRowNum, ApparatLastRowCom, num, com);
    }

    public void ClickApparatDeleteButton(){
        actionsWithWebElements.ClickElement(ApparatDeleteButton);
    }

}
