
Feature:Account Activity page

  Background:
    Given the user is on the login page
    And user logs in with valid credentials
    When the user should click "Account Activity"

  Scenario:Verify title of account summary page
    Then verify that account summary page should have the title "Zero - Account Activity"


  Scenario:In the Account drop down default option should be Savings.
    Then verify that Account drop down default option should be "Savings"

  Scenario:Account drop down options
    Then Account drop down should have the following options:
     |Savings|
     |Checking|
     |Loan    |
     |Credit Card|
     |Brokerage  |


  Scenario:Names of transactions table
    Then Transactions table should have column names
     |Date|
     |Description|
     |Deposit|
     |Withdrawal|

