package com.waikato.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.waikato.base.BasePage;

public class ApplicationScreen extends BasePage {

    private final static Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//input[@name='NEW_USER.DUMMY.MENSYS.1']")
    private WebElement btnNewUser;

    By Firstnamelocator = By.xpath("//input[@name='IPU_FNM1.IPU.SRS.1']");


    public ApplicationScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public CreatePortalLoginScreen naviagtePortalLogin() {
        logger.info("User can see the Apply to Study at Waikato Screen");
        click(btnNewUser);
        logger.info("User click New User Button on Apply to Study at Waikato Screen");
        waitforVisibility(Firstnamelocator, 10);
        logger.info("User can see the Create Portal Login Screen");

        return new CreatePortalLoginScreen(driver);
    }
}
