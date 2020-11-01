
Feature:Pay Bills page

  Background:
    Given the user is on the login page
    And user logs in with valid credentials
    When the user should click "Pay Bills"


  Scenario:Verify title of account summary page
    Then verify that account summary page should have the title "Zero – Pay Bills"

  Scenario:Successful Pay operation
    Then the user choose the Payee from one of the options, "Apple"
    And the user choose the Account from one of the options, "Savings"
    And the user should enter valid  10000
    And the user should enter valid  date "2020-10-15"
    And the user should enter valid "No Problem"
    And the user should click pay button
    Then Verify "The payment was successfully submitted" should be displayed.

  Scenario:A payment without entering the  date,
    Then the user choose the Payee from one of the options, "Sprint"
    And the user choose the Account from one of the options, "Savings"
    And the user should enter valid  67000
    And the user should enter valid "No Problem"
    And the user should click pay button
    Then Verify "Please fill in this field." alert should be displayed for not enter "date"

  Scenario:A payment without entering the amount
    Then the user choose the Payee from one of the options, "Sprint"
    And the user choose the Account from one of the options, "Savings"
    And the user should enter valid  date "2020-10-15"
    And the user should enter valid "No Problem"
    And the user should click pay button
    Then Verify "Please fill in this field." alert should be displayed for not enter "amount"

  Scenario Outline: Should  enter valid characters in any field
   Then verify the user cant enter "<char>" characters in "<field>" field
    Examples:
      |char| field  |
      |A   | Date |
      |B   | Date |
      |C   | Date |
      |A   | Amount |
      |B   | Amount |
      |C   | Amount |
      |.   | Amount |
      |,   | Amount |
      |~   | Amount |


