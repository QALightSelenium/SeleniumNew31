package pages;

import libs.ActionsWithWebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{



    String a = "Учет запчасте";

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='pull-left image']")
    WebElement avatar;

    @FindBy(xpath = "//ul[@class = 'sidebar-menu']//span[text() = 'Словари']")
    WebElement menuDictionary;

    @FindBy(xpath = "//a[@href='/dictionary/apparat']" )
    WebElement subMenuApparat;

    @FindBy(xpath = "//li[@id='dictionary']/a[//child::i]")
    WebElement Slovari;

    @FindBy(xpath = "//li[@id='apparat']/a")
    WebElement Aparat;


    public void openSlovariList(){

        actionsWithWebElements.buttonClick(Slovari);

    }

    public void openAparatPage(){

        actionsWithWebElements.buttonClick(Aparat);

    }

    public boolean isAvatarPresent(){
        return actionsWithWebElements.isElementPresent(avatar);
    }

}
