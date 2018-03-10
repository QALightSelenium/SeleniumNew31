package pages;

import libs.ActionsWithWebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    public WebDriver driver;
    public ActionsWithWebElements actionsWithWebElements;
    public Logger log;

    public ParentPage(WebDriver driver){

        this.driver = driver;
        log = Logger.getLogger(getClass());
        this.actionsWithWebElements = new ActionsWithWebElements(driver);

        PageFactory.initElements(driver, this);     //Позволяє звернутися до статичного класу 'By' перетворить в веб елементи

    }

    @FindBy(tagName="h1")
    protected WebElement zagolovok;

    public String getTitle(){
        return driver.getTitle();
    }

    public void checkTitle(String title){
        Assert.assertEquals("Title is not matched", zagolovok.getText(), title);
    }

    public void checkZagolovok(String zagolovokText){

        Assert.assertEquals("zagolovok is not matched", zagolovok.getText(), zagolovokText);

    }

    public String getValueFromField(WebElement element){

        return element.getText();

    }

}
