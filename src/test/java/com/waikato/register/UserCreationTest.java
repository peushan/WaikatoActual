package com.waikato.register;

import java.io.IOException;
import java.util.Map;

import com.waikato.pageobjects.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.waikato.base.BaseTest;

public class UserCreationTest extends BaseTest {

    @Test()
    public void RegistrationTest() throws IOException {

        SoftAssert sAssert = new SoftAssert();

        ApplicationScreen applicationScreen = new ApplicationScreen(driver);
        CreatePortalLoginScreen createPortalLoginScreen = applicationScreen.naviagtePortalLogin();
        QualificationSearchScreen qualificationSearchScreen = createPortalLoginScreen.navigateAccount();
        Qualificationselection qualificationselection = qualificationSearchScreen.navigatetoQualificationSelect();
        QualificationApplicationScreen qualificationApplicationScreen = qualificationselection.navigateQualificationApplication();
        qualificationApplicationScreen.navigateSubmitScreen();


        sAssert.assertAll();

    }
}
