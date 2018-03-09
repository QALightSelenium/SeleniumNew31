package pages;

import libs.ConfigData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    WebElement InputLoginElement;
    @FindBy(id = "password")
    WebElement InputPasswordElement;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement SubmitButton;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void OpenLoginPage(){
        try {
            driver.get(ConfigData.getCfgValue("base_url")+"/login");
            log.info("page is opened");
        }catch (Exception ex){
            log.error("Page not open" + ex);
            Assert.fail("Can not open URL");
        }
    }


    public void InputLoginName(String login){
        actionsWithWebElements.InputToTextField(InputLoginElement, login);
    }

    public void InputPassword (String pass){
        actionsWithWebElements.InputToTextField(InputPasswordElement, pass);
    }

    public void ClickSubmitButton(){
        actionsWithWebElements.ClickElement(SubmitButton);
    }

    public void LoginUser(String login, String pass){
        OpenLoginPage();
        InputLoginName(login);
        InputPassword(pass);
        ClickSubmitButton();
    }


}
