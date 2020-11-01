package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class AccountSummaryStepDefs {

    @Then("verify that account summary page should have the title {string}")
    public void verify_that_account_summary_page_should_have_the_title(String actualTitle) {
        waitFor(3);
        String expectedTitle = Driver.get().getTitle();
        System.out.println("Title "+expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Then("verify that account summary page should have to following account types:")
    public void verify_that_account_summary_page_should_have_to_following_account_types(List<String> list) {
        AccountSummaryPage account_summaryPage=new AccountSummaryPage();
        List<String> textList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            textList.add(account_summaryPage.accountTypes.get(i).getText());
        }
        Assert.assertEquals(textList,list);
    }

    @Then("verify that  credit Accounts table must have columns")
    public void verify_that_credit_Accounts_table_must_have_columns(List<String> list) {
        AccountSummaryPage account_summaryPage=new AccountSummaryPage();
        List<String> textList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            textList.add(account_summaryPage.creditAccountTable.get(i).getText());
        }
        Assert.assertEquals(textList,list);
    }
}