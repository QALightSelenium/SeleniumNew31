package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparatPage extends ParentPage {

    @FindBy(xpath = "//*[@class='content-header']//h1")
    WebElement ApparatPageTitle;
    @FindBy(id = "//div[@class='box-tools']/a")
    WebElement AddApparatButton;
    @FindBy(id = "apparat_apparatNumber")
    WebElement ApparatNumber;
    @FindBy(id = "apparat_apparatComment")
    WebElement ApparatComment;
    @FindBy(xpath = "//button[@name='add']")
    WebElement ApparatCreateButton;
    @FindBy(xpath = "//table[@id='device_list']//tbody/tr[last()]")
    WebElement ApparatLastRow;
    @FindBy(xpath = "//button[@name='delete']")
    WebElement ApparatDeleteButton;

    public ApparatPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return actionsWithWebElements.isElementPresent(ApparatPageTitle);
    }

    public void clickOnAddButton() { actionsWithWebElements.ClickElement(AddApparatButton);}

    public boolean isLabelPresent() {
        return actionsWithWebElements.isElementPresent(ApparatNumber);
    }

    public void InputApparatNumber(String appNumber){
        actionsWithWebElements.InputToTextField(ApparatNumber, appNumber);
    }

    public void InputApparatComment(String appComment){
        actionsWithWebElements.InputToTextField(ApparatComment, appComment);
    }

    public void ClickApparatCreateButton(){
        actionsWithWebElements.ClickElement(ApparatCreateButton);
    }

    public void ClickApparatLastRow(){
        actionsWithWebElements.ClickElement(ApparatLastRow);
    }

    public void ClickApparatDeleteButton(){
        actionsWithWebElements.ClickElement(ApparatCreateButton);
    }

}
