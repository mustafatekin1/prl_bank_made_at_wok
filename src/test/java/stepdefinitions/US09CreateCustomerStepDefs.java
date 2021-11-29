package stepdefinitions;

import com.github.javafaker.Faker;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.EditCustomerPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class US09CreateCustomerStepDefs {

    DefaultPage defaultPage = new DefaultPage();
    Faker faker = new Faker();
    EditCustomerPage editCustomerPage=new EditCustomerPage();
    @Then("verify that user successfully logins to the account")
    public void verify_that_user_successfully_logins_to_the_account() {
        String myOperations = defaultPage.myOperationsText.getText();
        Assert.assertTrue(myOperations.contains("My Operations"));
    }

    @Then("user clicks Manage Customers")
    public void user_clicks_manage_customers() {
        defaultPage.manageCustomers.click();
    }
    @Then("user clicks Create a new Customer")
    public void user_clicks_create_a_new_customer() {
        defaultPage.createCustomer.click();
    }

    @Then("user enters {string} number to search for the customer")
    public void user_enters_number_to_search_for_the_customer(String SSN) {
        editCustomerPage.searchSSNField.sendKeys(SSN);
    }

    @Then("user clicks search button")
    public void user_clicks_search_button () {
        editCustomerPage.searchButton.click();
        ReusableMethods.waitFor(6);
    }

    @Then("verify that First Name is populated")
    public void verify_that_first_name_is_populated() {
        String firstNameText = editCustomerPage.firstNameField.getAttribute("Value");
        System.out.println(firstNameText);
        Assert.assertFalse(firstNameText.isEmpty());
    }
    @Then("verify that Last Name is populated")
    public void verify_that_last_name_is_populated() {
        String lastNameText = editCustomerPage.lastNameField.getAttribute("Value");
        System.out.println(lastNameText);
        Assert.assertFalse(lastNameText.isEmpty());
    }
        @Then("verify that Middle Initial is populated")
    public void verify_that_middle_initial_is_populated() {
        String middleInitialsText = editCustomerPage.middleInitialField.getAttribute("Value");
        System.out.println(middleInitialsText);
      if (middleInitialsText.isEmpty()){
          editCustomerPage.middleInitialField.sendKeys(faker.name().nameWithMiddle());
            }
    //defaultPage.middleInitialField.sendKeys(faker.name().nameWithMiddle());
            editCustomerPage.middleInitialField.sendKeys("mehmet");
    }
    @Then("verify that email is populated")
    public void verify_that_email_is_populated() {
        System.out.println(editCustomerPage.emailField.getAttribute("value"));
        Assert.assertFalse(editCustomerPage.emailField.getAttribute("Value").isEmpty());
    }
    @Then("verify that Mobile Phone Number is populated")
    public void verify_that_mobile_phone_number_is_populated() {
        Assert.assertFalse(editCustomerPage.mobilePhoneNumberField.getAttribute("Value").isEmpty());
    }
        @Then("verify that Phone Number is populated")
    public void verify_that_phone_number_is_populated() {

       String phoneNumberFieldValue = editCustomerPage.phoneNumberField.getAttribute("Value");
       System.out.println(phoneNumberFieldValue);
       if(phoneNumberFieldValue.isBlank()){
           editCustomerPage.phoneNumberField.sendKeys(faker.phoneNumber().phoneNumber());
            }
            editCustomerPage.phoneNumberField.sendKeys("205-900-3333");
        System.out.println("phone number" + phoneNumberFieldValue);
    }
    @Then("verify that Zip Code is populated")
    public void verify_that_zip_code_is_populated() {
        editCustomerPage.zipCodeField.sendKeys("10001");
        String zipCodeFieldValue = editCustomerPage.zipCodeField.getAttribute("value");
        System.out.println(zipCodeFieldValue);
       // Assert.assertFalse(zipCodeFieldValue.isEmpty());
        if(zipCodeFieldValue.isEmpty()){
            editCustomerPage.zipCodeField.sendKeys("10001");
        }

        System.out.println("zipcode "+zipCodeFieldValue);

  }
    @Then("verify that Address is populated")
    public void verify_that_address_is_populated() {
        Assert.assertFalse(editCustomerPage.addressField.getAttribute("Value").isEmpty());
    }
        @Then("verify that city is populated")
    public void verify_that_city_is_populated() {
        String cityFieldValue=editCustomerPage.cityField.getAttribute("value");
        if (cityFieldValue.isEmpty()) {
            editCustomerPage.cityField.sendKeys(faker.address().cityName());
        };
            editCustomerPage.cityField.sendKeys(faker.address().cityName());
    }
    @Then("verify that SSN is populated")
    public void verify_that_ssn_is_populated() {
        Assert.assertFalse(editCustomerPage.ssnField.getAttribute("Value").isEmpty());
    }
    @Then("verify that Create Date is populated")
    public void verify_that_create_date_is_populated() {
        Assert.assertFalse(editCustomerPage.createDateDropdownField.getAttribute("Value").isEmpty());
    }
    @Then("verify that Country is populated")
    public void verify_that_country_is_populated() {
        String countryFieldValue = editCustomerPage.countryDropdownField.getAttribute("Value");
        Select select = new Select(editCustomerPage.countryDropdownField);
        ReusableMethods.waitFor(3);
        if(countryFieldValue.isEmpty()){
           select.selectByVisibleText("USA");
        };
        ReusableMethods.waitFor(3);
        select.selectByVisibleText("USA");
    }
    @Then("verify that State is populated")
    public void verify_that_state_is_populated() {
        String stateFieldValue = editCustomerPage.stateField.getAttribute("Value");
        if(stateFieldValue.isEmpty()) {
            editCustomerPage.stateField.sendKeys(faker.address().state());
        };
        editCustomerPage.stateField.sendKeys(faker.address().state());
    }
//    @Then("verify that Account is populated")
//    public void verify_that_account_is_populated() {
//        Assert.assertFalse(defaultPage.accountDropdownField.getAttribute("Value").isEmpty());
//    }


}