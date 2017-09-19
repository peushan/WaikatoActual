package com.waikato.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseFramework {

    private final static Logger logger = Logger.getLogger(BasePage.class);

    // Generic Methods

    /**
     * wrapped method for Webdriver Click This method should be improved to log the
     * behavior
     *
     * @param element
     */

    protected void click(WebElement element) {
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
            } else {
                sleep(1);
                element.click();
            }
        } catch (NoSuchElementException f) {
            logger.error("\nElement not visible in screen : " + f.getMessage());
            throw new ElementNotVisibleException("Element not displayed in webpage.");
        } catch (WebDriverException e) {
            try {
                element.click();
            } catch (Exception d) {
                logger.error("click(element) failed with error : " + d.getMessage());
            }
        } catch (Exception g) {
            logger.error("click(element) failed with error : " + g.getMessage());
        }
    }

    protected void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrapped method for Webdriver sendKeys This method should be improved to log
     * the behavior
     *
     * @param element
     * @param text
     */
    protected void sendKeys(WebElement element, String text) {
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException e) {
            try {
                element.sendKeys(text);
            } catch (Exception d) {
                logger.error("sendKeys(element: " + element + "text: " + text + ") failed with error : " + e.getMessage());
            }
        } catch (Exception e) {
            logger.error("sendKeys(element: " + element + "text: " + text + ") failed with error : " + e.getMessage());
        }
    }

    /**
     * waiting for locator
     *
     * @param locator
     * @param timeOutInSeconds
     */

    protected void waitforVisibility(By locator, Integer... timeOutInSeconds) {
        int attempt = 0;
        while (attempt < 3) {
            try {
                waitfor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
                break;
            } catch (StaleElementReferenceException e) {
                // TODO: handle exception
            }
            attempt++;
        }

    }

    private void waitfor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);

    }

    protected void select(WebElement webElement, String value) {
        if (new Select(webElement).isMultiple());
        new Select(webElement).selectByVisibleText(value);
    }

}
