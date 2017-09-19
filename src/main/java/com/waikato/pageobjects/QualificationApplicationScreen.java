package com.waikato.pageobjects;

import com.waikato.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by peushan on 9/19/2017.
 */

public class QualificationApplicationScreen extends BasePage {

    private final static Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//select[@id='IPQ_ADOAP_LCA']")
    private WebElement drpStudy;

    @FindBy(xpath = "//button[@id='app-btn-next']")
    private WebElement btnSaveContinue;

    @FindBy(xpath = "//input[@id='IPR_GEND_M']")
    private WebElement rdbtnMale;
    By rdbtnMale1 = By.xpath("//input[@id='IPR_GEND_M']");

    @FindBy(xpath = "//select[@id='IPQ_ADOAP_NID1']")
    private WebElement drpResidencyStatus;

    @FindBy(xpath = "//select[@id='IPQ_ADOAP_CODC']")
    private WebElement drpCitizenShip;

    @FindBy(xpath = "//input[@id='IPQ_ADOAP_LOCL1']")
    private WebElement rdbtnStudyPeriod;

    @FindBy(xpath = "//select[@id='IPQ_ADOAP_ETH1']")
    private WebElement drpEthnicity;

    @FindBy(xpath = "//input[@id='IPR_CAD1']")
    private WebElement txtAddressline1;

    @FindBy(xpath = "//input[@id='IPR_CAD5']")
    private WebElement txtCityTown;

    @FindBy(xpath = "//input[@id='IPR_CAPC']")
    private WebElement txtPostCode;

    @FindBy(xpath = "//span[@id='IPR_COD2_chosenspan']")
    private WebElement drpCountry;

    @FindBy(xpath = "//input[@aria-owns='IPR_COD2_ul']")
    private WebElement txtCountryName;

    //Education
    @FindBy(xpath = "//input[@id='ADOAP_EDSSQ2']")
    private WebElement rdbtnSecondary;

    @FindBy(xpath = "//span[@id='IPQ_ADOAP_EDLSCL_chosenspan']")
    private WebElement drpSecondryAttend;

    @FindBy(xpath = "//input[@aria-owns='IPQ_ADOAP_EDLSCL_ul']")
    private WebElement txtSchoolAttend;

    @FindBy(xpath = "//select[@id='IPQ_ADOAP_EDLSTY']")
    private WebElement drpLastSchoolAttend;

    @FindBy(xpath = "//select[@id='IPQ_ADOAP_EDHQAL']")
    private WebElement drpHighestQualification;

    @FindBy(xpath = "//input[@id='ADOAP_EDPTS2']")
    private WebElement rdbtnStudyPrevious;

    //Additional info
    @FindBy(xpath = "//input[@id='ADOAP_INTAG1_4']")
    private WebElement rdbtnAreYoufollowing;

    @FindBy(xpath = "//input[@id='IPQ_ADOAP_TEACHY']")
    private WebElement rdbtnAreYouregisteredTeacher;


    public QualificationApplicationScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);

    }

    public SubmitScreen navigateSubmitScreen() {

        //Location and subject selection
        logger.info("User able to see the Location and subject selection");
        select(drpStudy, "Hamilton");
        click(btnSaveContinue);

        //Personal details
        waitforVisibility(rdbtnMale1);
        logger.info("User able to see the Personal details");
        click(rdbtnMale);
        //driver.findElement(By.xpath("//"))
        select(drpResidencyStatus, "Other");
        select(drpCitizenShip, "Sri Lanka");
        click(rdbtnStudyPeriod);
        select(drpEthnicity, "Sri Lankan");
        click(btnSaveContinue);

        //Contact details
        logger.info("User able to see the Contact details");
        sendKeys(txtAddressline1, "Test");
        sendKeys(txtCityTown, "Kelaniya");
        sendKeys(txtPostCode, "094");
        click(drpCountry);
        sendKeys(txtCountryName, "Sri Lanka");
        txtCountryName.sendKeys(Keys.RETURN);
        sleep(2);
        click(btnSaveContinue);

        //Education
        logger.info("User able to see the Education details");
        click(rdbtnSecondary);
        click(drpSecondryAttend);
        sendKeys(txtSchoolAttend, "ACG New Zealand International College");
        txtSchoolAttend.sendKeys(Keys.RETURN);
        sleep(1);
        select(drpLastSchoolAttend, "2020");
        select(drpHighestQualification, "30 or more credits at level 3 or above");
        click(rdbtnStudyPrevious);
        click(btnSaveContinue);

        //Additional info

        click(rdbtnAreYoufollowing);
        click(rdbtnAreYouregisteredTeacher);
        click(btnSaveContinue);


        return new SubmitScreen(driver);


    }


}
