package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        LoginPage loginPage =new LoginPage();
        loginPage.buttonSignIn.click();
        waitFor(3);
        loginPage.userNameLogIn.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordLogIn.sendKeys(ConfigurationReader.get("password"));
        loginPage.buttonLogIn.click();

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String actualTitle="Zero - Account Activity";
        String expectedTitle = Driver.get().getTitle();
        System.out.println("Title "+expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        new AccountSummaryPage().linkText(string).click();
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        Assert.assertTrue(new AccountActivityPage().accountIdSelect(string).isSelected());
    }

}
