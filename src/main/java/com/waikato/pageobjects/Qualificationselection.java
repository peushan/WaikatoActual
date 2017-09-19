package com.waikato.pageobjects;

import com.waikato.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by peushan on 9/19/2017.
 */
public class Qualificationselection extends BasePage {

    private final static Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//input[@name='APPLY.IPO.SRS.1']")
    private WebElement btnApply;

    By txtProgress = By.xpath("//span[@class='progress-marker']");

    public Qualificationselection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public QualificationApplicationScreen navigateQualificationApplication() {
        click(btnApply);
        waitforVisibility(txtProgress);
        logger.info("User able to see the Qualification Application Screen");
        return new QualificationApplicationScreen(driver);
    }
}
