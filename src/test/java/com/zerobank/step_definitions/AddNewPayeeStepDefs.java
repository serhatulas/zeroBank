package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Map;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class AddNewPayeeStepDefs {
 AccountSummaryPage accountSummaryPage =new AccountSummaryPage();
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        String url = ConfigurationReader.get("url");
        Driver.get().manage().window().maximize();
        Driver.get().get(url);
        LoginPage loginPage =new LoginPage();
        loginPage.buttonSignIn.click();
        waitFor(3);
        loginPage.userNameLogIn.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordLogIn.sendKeys(ConfigurationReader.get("password"));
        loginPage.buttonLogIn.click();
        accountSummaryPage.linkText("Pay Bills").click();
        accountSummaryPage.linkText("Add New Payee").click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> map) {
        PayBillPage payBillPage =new PayBillPage();
        waitFor(2);
        payBillPage.newPayeeName.sendKeys(map.get("Payee Name"));
        payBillPage.newPayeeAdress.sendKeys(map.get("Payee Address"));
        payBillPage.newPayeeAccount.sendKeys(map.get("Account"));
        payBillPage.newPayeeDetails.sendKeys(map.get("Payee details"));
        payBillPage.newPayeeAddButton.click();
    }

    @Then("message  The new payee The Law offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        PayBillPage payBillPage =new PayBillPage();
        String expectedText="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Assert.assertEquals(expectedText,payBillPage.newPayeeConfirmationText.getText());
    }



}
