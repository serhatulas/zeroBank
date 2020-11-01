package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class AccountActivityStepDefs {

    @When("the user should click {string}")
    public void the_user_should_click(String string) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.headMenuPath(string).click();
    }

    @Then("verify that Account drop down default option should be {string}")
    public void verify_that_Account_drop_down_default_option_should_be(String string) {
        Assert.assertTrue(new AccountActivityPage().accountIdSelect(string).isSelected());
    }

    @Then("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> list) {
     Select select =new Select(new AccountActivityPage().accountIdSelect);
     List<String>expectedList=new ArrayList<>();
        for (int i = 0; i < select.getOptions().size(); i++) {
            expectedList.add(select.getOptions().get(i).getText());
        }
        Assert.assertEquals(expectedList,list);
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> list) {
        waitFor(3);
        List<String>expectedList=new ArrayList<>();
        for (int i = 0; i < new AccountActivityPage().transactionsTable.size(); i++) {
            expectedList.add(new AccountActivityPage().transactionsTable.get(i).getText());
        }
        Assert.assertEquals(expectedList,list);
    }

}
