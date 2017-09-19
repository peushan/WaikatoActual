package com.waikato.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.waikato.base.BasePage;

public class CreatePortalLoginScreen extends BasePage {

    private final static Logger logger = Logger.getLogger(BasePage.class);


    @FindBy(xpath = "//input[@name='IPU_FNM1.IPU.SRS.1']")
    private WebElement txtFirstName;

    @FindBy(xpath = "//input[@name='IPU_SURN.IPU.SRS.1']")
    private WebElement txtLastName;

    @FindBy(xpath = "//input[@name='IPU_DOB.IPU.SRS.1']")
    private WebElement txtDOB;

    @FindBy(xpath = "//input[@name='IPU_CAEM.IPU.SRS']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@name='USERCODE.IPU.SRS']")
    private WebElement txtConfirmEmail;

    @FindBy(xpath = "//input[@name='PASSWORD1.IPU.SRS.1']")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@name='PASSWORD2.IPU.SRS.1']")
    private WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='PROCEED.DUM1.SRS.1']")
    private WebElement btnCreateAccount;


    public CreatePortalLoginScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    By qualificationlocator = By.xpath("//select[@name='SELECTION.CRITERIA.SRS.1-1']");

    public QualificationSearchScreen navigateAccount() {

        sendKeys(txtFirstName, "Peushan1");
        sendKeys(txtLastName, "Panagoda1");
        sendKeys(txtDOB, "11/Sep/1988");
        sendKeys(txtEmail, "peushanpanagoda10@gmail.com");
        sendKeys(txtConfirmEmail, "peushanpanagoda10@gmail.com");
        sendKeys(txtPassword, "qwert12345@");
        sendKeys(txtConfirmPassword, "qwert12345@");
        click(btnCreateAccount);
        waitforVisibility(qualificationlocator,10);
        logger.info("User can see the Qualification Search Screen ");

        return new QualificationSearchScreen(driver);
    }

}
