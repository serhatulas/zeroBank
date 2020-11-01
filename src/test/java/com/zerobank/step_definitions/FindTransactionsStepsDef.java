package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.WebRowSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class FindTransactionsStepsDef {
    AccountActivityPage accountActivityPage=new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityNavigationStepDefs().the_user_is_logged_in();
        new AccountSummaryPage().linkText("Account Activity").click();
        waitFor(2);
        new AccountSummaryPage().linkText("Find Transactions").click();
        waitFor(2);
    }
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        accountActivityPage.datesFindTransactionFromInput.clear();
        accountActivityPage.datesFindTransactionFromInput.sendKeys(string);
        accountActivityPage.datesFindTransactionToInput.clear();
        accountActivityPage.datesFindTransactionToInput.sendKeys(string2);
        waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < accountActivityPage.dateTableFindTransaction.size(); i++) {
            list.add(accountActivityPage.dateTableFindTransaction.get(i).getText());
        }
        System.out.println("SIZE "+accountActivityPage.dateTableFindTransaction.size());
        for (int i = 0; i <list.size(); i++) {
            System.out.println(accountActivityPage.dateTableFindTransaction.get(i).getText()+" COMPARE RESULT "+new AccountActivityPage().dateCompare(list.get(i), string, string2));
            Assert.assertTrue(accountActivityPage.dateCompare(list.get(i), string, string2));
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> actualList=new ArrayList<>();
        for (int i = 0; i <accountActivityPage.dateTableFindTransaction.size(); i++) {
            actualList.add(accountActivityPage.dateTableFindTransaction.get(i).getText());
        }
        List <String> expectedlist=new ArrayList<>();
        expectedlist=accountActivityPage.sortedByRecentDates(actualList);
        Assert.assertEquals(expectedlist,actualList);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        List<String> actualList=new ArrayList<>();
        for (int i = 0; i < accountActivityPage.dateTableFindTransaction.size(); i++) {
            actualList.add(accountActivityPage.dateTableFindTransaction.get(i).getText());
        }
        for (int i = 0; i < actualList.size(); i++) {
            Assert.assertNotEquals(actualList.get(i), string);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        accountActivityPage.descriptionTextBox.clear();
        accountActivityPage.descriptionTextBox.sendKeys(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        String text="";
        try{
            text=accountActivityPage.descriptionTableRow.getText();
        }catch(Exception e){
            System.out.println("Exception "+e.getMessage());
        }
        Assert.assertTrue(text.contains(string));

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        if (string.equalsIgnoreCase("OFFICE")) {
            the_user_enters_description("ONLINE");
            clicks_search();
        } else if(string.equalsIgnoreCase("ONLINE")) {
                the_user_enters_description("OFFICE");
                clicks_search();
            }
        Assert.assertFalse(accountActivityPage.descriptionTableRow.getText().contains(string));
    }

    @Given("clicks search")
    public void clicks_search() {
        accountActivityPage.findButton.click();
        waitFor(5);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        int rowNumber=accountActivityPage.getnumberOfRowsWithHeadFromTable();
        List <String> list =new ArrayList<>();
        for (int i = 2; i <= rowNumber; i++) {
            String text=accountActivityPage.getCellElementByIndex(i,3).getText().replaceAll("\\s+","");
            list.add(text); list.remove("");
        }
        Assert.assertTrue(list.size()>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        int rowNumber=accountActivityPage.getnumberOfRowsWithHeadFromTable();
        List <String> list =new ArrayList<>();
        for (int i = 2; i <= rowNumber; i++) {
            String text=accountActivityPage.getCellElementByIndex(i,4).getText().replaceAll("\\s+","");
            list.add(text); list.remove("");
        }
        Assert.assertTrue(list.size()>0);
    }



    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        int rowNumber=accountActivityPage.getnumberOfRowsWithHeadFromTable();
        List <String> list =new ArrayList<>();
        for (int i = 2; i <= rowNumber; i++) {
            String text=accountActivityPage.getCellElementByIndex(i,4).getText().replaceAll("\\s+","");
            list.add(text); list.remove("");
        }
        Assert.assertTrue(list.size()==0);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        int rowNumber=accountActivityPage.getnumberOfRowsWithHeadFromTable();
        List <String> list =new ArrayList<>();
        for (int i = 2; i <= rowNumber; i++) {
            String text=accountActivityPage.getCellElementByIndex(i,3).getText().replaceAll("\\s+","");
            list.add(text); list.remove("");
        }
        Assert.assertTrue(list.size()==0);
    }


    @When("user selects type {string}")
    public void user_selects_type(String string) {
        Select select= new Select(accountActivityPage.typeSelect);
        select.selectByVisibleText(string);
        clicks_search();
    }




}