@login
Feature: user can login with valid credentials

  @customer_login
Scenario Outline:
  Given user opens the url
  When user navigates to login page
  And user enters username "<customer_username>"
  And user enters password "<customer_password>"
  Then verify that user successfully logins to the account


  Examples:
  |customer_username|customer_password|
  |bf_customer1     |Customer1*       |