package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ActionsWithWebElements {
    WebDriver driver;
    Logger log;

    public ActionsWithWebElements(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
    }

    /**
     * this method inputs text value into text field
     *
     * @param element
     * @param value
     */
    public void InputToTextField(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
            log.info(value + "  is inputed to " + element);
        } catch (Exception ex) {
            log.error("Login doesn't input " + ex);
        }
    }

    /**
     * This method clicks the web element
     *
     * @param element
     */
    public void ClickElement(WebElement element) {
        try {
            element.click();
            log.info("Button is clicked");
        } catch (Exception e) {
            log.error("Button is not clicked " + e);
        }
    }

    /**
     * this method checks if the element is present and enabled
     *
     * @param element
     * @return
     */
    public boolean isElementPresent(WebElement element) {
        return (element.isDisplayed() && element.isEnabled());
    }

    /**
     * This method selects visible elementDD from Drop Down list by text - textForSelect
     *
     * @param elementDD
     * @param textForSelect
     */
    public void selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect) {
        try {
            Select optionFromDD = new Select(elementDD);
            optionFromDD.selectByVisibleText(textForSelect);
            log.info(textForSelect + " was selected DD");
        } catch (Exception e) {
            log.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    /**
     * This method selects visible elementDD from Drop Down list by value - valueForSelect
     *
     * @param elementDD
     * @param vallueForSelect
     */
    public void selectItemInDropDownByValue(WebElement elementDD, String vallueForSelect) {
        try {
            Select optionFromDD = new Select(elementDD);
            optionFromDD.deselectByValue(vallueForSelect);
            log.info(vallueForSelect + " was selected DD");
        } catch (Exception e) {
            log.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    /**
     * This method checks or unchecks the checkbox
     *
     * @param element
     * @param neededState
     */
    public void SelectCheckbox(WebElement element, boolean neededState) {
        try {
            if ((element.isSelected() && !neededState) || (!element.isSelected()) && neededState) {
                element.click();
            }
        } catch (Exception e) {
            log.error("Error" + e);
        }
    }


}
