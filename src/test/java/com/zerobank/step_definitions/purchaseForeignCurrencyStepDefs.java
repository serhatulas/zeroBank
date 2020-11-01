package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class purchaseForeignCurrencyStepDefs {
    PayBillPage payBillPage= new PayBillPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
       new LoginStepDefs().the_user_is_on_the_login_page();
       new LoginStepDefs().user_logs_in_with_valid_credentials();
       waitFor(2);
       new AccountActivityPage().headMenuPath("Pay Bills").click();
        waitFor(2);
       new AccountSummaryPage().linkText("Purchase Foreign Currency").click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available( List <String> expectedList) {
        waitFor(2);
        Select select=new Select(new PayBillPage().foreignCurrencySelect);
        List<WebElement> list=select.getOptions();
        List <String> actualList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
             actualList.add(list.get(i).getText());
        }
        actualList.remove(0);
        for (int i = 0; i <expectedList.size(); i++) {
            Assert.assertTrue(actualList.contains(expectedList.get(i)));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        waitFor(3);
        payBillPage.purchaseButton.click();


    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String alertMessage= Driver.get().switchTo().alert().getText();
        System.out.println("ALERT MESSAGE "+alertMessage);
        Assert.assertFalse(alertMessage.isEmpty());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        waitFor(3);
        Select select=new Select(new PayBillPage().foreignCurrencySelect);
        select.selectByIndex(3);
        payBillPage.currencyRadioButton.click();
        payBillPage.purchaseButton.click();
    }

}
