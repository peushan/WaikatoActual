package com.waikato.pageobjects;

import com.waikato.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.print.attribute.standard.MediaSizeName;
import java.io.IOException;

public class QualificationSearchScreen extends BasePage {

    private final static Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//select[@name='SELECTION.CRITERIA.SRS.1-1']")
    private WebElement drpTypeofQualification;

    @FindBy(xpath = "//input[@name='BP102.DUMMY_B.MENSYS']")
    private WebElement btnSearch;

    @FindBy(xpath = "//h2[@class='sv-panel-title resultsTitle']")
    private WebElement txtResults;

    @FindBy(xpath = "//ul[@id='courses']/li[1]")
    private WebElement listCourses;

    @FindBy(linkText = "Bachelor of Teaching")
    private WebElement listCourses1;

    By txtReulsts = By.xpath("//h2[@class='sv-panel-title resultsTitle']");


    public QualificationSearchScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public Qualificationselection navigatetoQualificationSelect() {

        select(drpTypeofQualification, "Bachelors Degree");
        click(btnSearch);
        waitforVisibility(txtReulsts);
        logger.info("User able to see the Search Results");
        //click(listCourses);
        click(listCourses1);
        logger.info("User able to see Qualification selection Screen");
        return new Qualificationselection(driver);


    }

}
