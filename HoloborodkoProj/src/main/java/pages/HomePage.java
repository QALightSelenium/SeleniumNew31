package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = "//*[@class='logo']")
    WebElement avatar;
    @FindBy(xpath = ".//*[@id='dictionary']/a")
    WebElement menuDictionary;
    @FindBy(xpath = ".//*[@id='apparat']/a")
    WebElement subMenuApparat;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isAvatarPresent() {
        return actionsWithWebElements.isElementPresent(avatar);
    }

    public void clickOnMenuDictionary() {
        actionsWithWebElements.ClickElement(menuDictionary);
    }

    public void clickOnSubMenuApparat() {
        actionsWithWebElements.ClickElement(subMenuApparat);
    }

}
