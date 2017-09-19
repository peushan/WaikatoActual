package com.waikato.cucumber;

import com.waikato.base.BaseTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.util.Map;


public class StepDefinition extends BaseTest {

    @Given("^I have open the browser$")
    public void I_have_open_the_browser() throws IOException {
    }

    @When("^I login to the application using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void I_login_to_the_application_using_and(String email, String password) throws IOException {
        //QualificationSearchScreen instructorRegister = PageFactory.initElements(driver, QualificationSearchScreen.class);
        //instructorRegister.register();
   /*     SoftAssert sAssert = new SoftAssert();

        ApplicationScreen applicationScreen = new ApplicationScreen(driver);
        CreatePortalLoginScreen createPortalLoginScreen = applicationScreen.naviagteSearch();
        QualificationSearchScreen instructorRegister = createPortalLoginScreen.navigateInstructor();
        instructorRegister.register("01", "pduxhzn", "Test");
        sAssert.assertAll();*/

    }

    @Then("^Welcome page should be displayed$")
    public void Welcome_page_should_be_displayed() {
        tearDown();
    }

    @When("^I login to the application$")
    public void I_login_to_the_application(DataTable dataTable) {

        Map<String, String> datamap = dataTable.asMap(String.class, String.class);
        datamap.get("email");

    }

}
