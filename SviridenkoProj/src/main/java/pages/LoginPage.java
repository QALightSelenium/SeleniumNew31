package pages;

import libs.ActionsWithWebElements;
import libs.ConfigData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends ParentPage {

    @FindBy(xpath="//*[@name='_username']")
    WebElement LoginNameInputXpath;

    @FindBy(id="password")
    WebElement PasswordInputId;

    @FindBy(xpath="//button[contains(text(), 'Вход') and @type='submit']")
    WebElement ButtonSubmitType;




    public LoginPage(WebDriver driver)
    {
        super(driver);

    }

    public void OpenLoginPage() throws IOException
    {

        try {

            driver.get(ConfigData.getCfgValue("base_url")+"/login");

        }
        catch (Exception ex){

            Assert.fail("Cant open page");
        }

    }

    public void inputLoginName(String login)
    {

        actionsWithWebElements.inputValueField(LoginNameInputXpath, login);

    }

    public void inputPasswordId(String password)
    {

        actionsWithWebElements.inputValueField(PasswordInputId, password);

    }

    public void clickSubmitButton()
    {

        actionsWithWebElements.buttonClick(ButtonSubmitType);

    }

    public void loginUser(String login, String pass) throws IOException {

        OpenLoginPage();
        inputLoginName(login);
        inputPasswordId(pass);
        clickSubmitButton();

    }

}
