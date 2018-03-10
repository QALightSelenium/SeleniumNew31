package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ActionsWithWebElements {

    public WebDriver driver;
    public Logger log;
    WebDriverWait webDriverWait20;


    public ActionsWithWebElements(WebDriver driver){
        this.driver = driver;
        this.log = Logger.getLogger(getClass());
        this.webDriverWait20 = new WebDriverWait(driver, 20); //явне очікування

    }


    /**
     * Find a field on the page and set value
     * @param elementName element identificator
     * @param value       value that will be set
     */
    public void inputValueField(WebElement elementName, String value){

        try {
            elementName.clear();
            elementName.sendKeys(value);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Find a button and click on it
     * @param elementName element identificator
     */
    public void buttonClick(WebElement elementName){

        try {
            //webDriverWait20.until(visibilityOf(elementName));   //не викор visibloOf коли викор implisitly. !!! є іші метди які викор https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
            elementName.click();
//            //List l = driver.findElements(By.id()) ветрає колекцію а коли нема елемента вертає пусту колекцію
//                if(l.size() > 0){
//
//                }
//                else{
//                    log.info("No find element");
//                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * verify if element is on the page
     * @param element
     * @return
     */
    public boolean isElementPresent(WebElement element){

        return element.isDisplayed()&&element.isEnabled();

    }

    /**
     * select visible element from dropdown list
     * @param elementDD
     * @param textForSelect
     */
    public void selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect){

        try{

            Select optionFromDD = new Select(elementDD);
            optionFromDD.selectByVisibleText(textForSelect);
            log.info(textForSelect + "was selected in DD");

        }catch (Exception e){

            log.error("Cannot work with element");
            Assert.fail("Cannot work with element");

        }
    }

    /**
     * select  element by value from dropdown list
     * @param elementDD
     * @param textForSelect
     */
    public void selectItemInDropDownByValue(WebElement elementDD, String textForSelect){
        try{
            Select optionFromDD = new Select(elementDD);
            optionFromDD.selectByValue(textForSelect);
            log.info(textForSelect + "was selected in DD");
        }catch (Exception e){
            log.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    /**
     * select checkbox
     */
    public void clickOnCheckBox(WebElement element, boolean neededState) {


        try {
            if ((element.isSelected() && !neededState) || (!element.isSelected() && neededState)) {
                element.click();
            }

        } catch (Exception e) {
            log.info("element is not selected");
        }

    }

    /**
     * Explicitly wait
     */



}
