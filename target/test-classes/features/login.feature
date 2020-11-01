
Feature:Authorized users should be able to login to the application
  Background:
    Given the user is on the login page


  Scenario: Logs in with valid credentials
    When user logs in with valid credentials
    Then  users should be able to login to the application



  Scenario: Logs in with invalid credentials
    When user logs in with invalid credentials,
    Then Login and/or password are wrong, should be displayed


