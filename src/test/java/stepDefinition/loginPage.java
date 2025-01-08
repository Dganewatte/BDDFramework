package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testCases.LoginPageTest;

public class loginPage {

    LoginPageTest loginPageTest = new LoginPageTest();
    @Given("Launch the url")
    public void launch_the_url() {
        loginPageTest.setUp();
    }

    @Given("verify title as <title>")
    public void verify_title_as_title() {
        loginPageTest.validateTitle();
    }

    @Then("I close the browser")
    public void closeTheBrowser() throws Exception {
        loginPageTest.tearDown();
    }
}