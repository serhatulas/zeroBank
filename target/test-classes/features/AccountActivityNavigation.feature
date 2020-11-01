Feature: Navigating to specific accounts in Accounts Activity
  Background:
    Given the user is logged in

  Scenario Outline: <redirect> account redirect
    When the user clicks on "<redirect>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<redirect>" selected

    Examples:
    |redirect|
    |Savings|
    |Brokerage|
    |Credit Card|
    |Loan|
    |Checking|
