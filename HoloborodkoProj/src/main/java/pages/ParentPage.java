package pages;

import libs.ActionsWithWebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver driver;
    Logger log;
    ActionsWithWebElements actionsWithWebElements;

    @FindBy (tagName = "h1")
    protected WebDriver zagolovok;

    public ParentPage(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(getClass());
        actionsWithWebElements = new ActionsWithWebElements(driver);
        PageFactory.initElements(driver, this);
    }

    public  String getTitle(){
        return driver.getTitle();
    }

    protected void checkTitle (String title){
        Assert.assertEquals("Title not expected", getTitle(), title);
    }

    protected void checkZagolovok (String zagolovokText){
        Assert.assertEquals("Zagolovok not matched", zagolovok.getTitle(), zagolovokText);
    }

}
