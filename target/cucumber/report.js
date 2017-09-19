$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/LoginValidation.feature");
formatter.feature({
  "line": 1,
  "name": "Facebook Login feature",
  "description": "",
  "id": "facebook-login-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login To facebook Pages",
  "description": "",
  "id": "facebook-login-feature;login-to-facebook-pages",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have open the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I login to the application using \"email\" and \"password\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Welcome page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.I_have_open_the_browser()"
});
formatter.result({
  "duration": 35541094664,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "email",
      "offset": 34
    },
    {
      "val": "password",
      "offset": 46
    }
  ],
  "location": "StepDefinition.I_login_to_the_application_using_and(String,String)"
});
formatter.result({
  "duration": 76409239440,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.Welcome_page_should_be_displayed()"
});
formatter.result({
  "duration": 1199342270,
  "status": "passed"
});
});