package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    @Given("user opens the url")
    public void user_opens_the_url() {
        Driver.getDriver().get(ConfigReader.getProperty("project_url"));
    }
    @When("user navigates to login page")
    public void user_navigates_to_login_page() {
    loginPage.accountMenu.click();
    loginPage.signInMenu.click();
    }
    @When("user enters username {string}")
    public void user_enters_username(String customer_username) {
        loginPage.username.sendKeys(customer_username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String customer_password) {
        loginPage.password.sendKeys(customer_password);
    }
    @Then("verify that user successfully logins to the account")
    public void verify_that_user_successfully_logins_to_the_account() {
        loginPage.signInButton.click();
    }



}
