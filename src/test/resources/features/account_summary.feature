
Feature:Account summary page
Background:
  Given the user is on the login page
  And user logs in with valid credentials


  Scenario:Verify title of account summary page
    Then verify that account summary page should have the title "Zero - Account Summary"

  Scenario:Verify that account types of account summary page
    Then verify that account summary page should have to following account types:
      |Cash Accounts|
      |Investment Accounts|
      |Credit Accounts    |
      |Loan Accounts      |

  Scenario:Verify that columns of  credit Accounts table
    Then verify that  credit Accounts table must have columns
      |Account|
      |Credit Card|
      |Balance    |
