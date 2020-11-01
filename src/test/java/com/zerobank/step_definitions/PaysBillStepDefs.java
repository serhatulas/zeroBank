package com.zerobank.step_definitions;


import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class PaysBillStepDefs {


    @Then("the user choose the Payee from one of the options, {string}")
    public void the_user_choose_the_Payee_from_one_of_the_options(String string) {
        PayBillPage paybillpage = new PayBillPage();
        Select select = new Select(paybillpage.payeeSelect);
        select.selectByVisibleText(string);
    }


    @Then("the user choose the Account from one of the options, {string}")
    public void the_user_choose_the_Account_from_one_of_the_options(String string) {
        PayBillPage paybillpage = new PayBillPage();
        Select select = new Select(paybillpage.accountSelect);
        select.selectByVisibleText(string);
    }


    @Then("the user should enter valid  {int}")
    public void the_user_should_enter_valid(Integer amount) {
        String amountText = Integer.toString(amount);
        new PayBillPage().inputAmount.click();
        new PayBillPage().inputAmount.sendKeys(amountText);
    }

    @Then("the user should enter valid  date {string}")
    public void the_user_should_enter_valid_date(String string) {
        new PayBillPage().dateText.click();
        new PayBillPage().calender.click();
    }

    @Then("the user should enter valid {string}")
    public void the_user_should_enter_valid(String string) {
        new PayBillPage().descriptionText.sendKeys(string);
    }

    @Then("the user should click pay button")
    public void the_user_should_click_pay_button() {
        new PayBillPage().payButton.click();
    }

    @Then("Verify {string} should be displayed.")
    public void verify_should_be_displayed(String string) {
        Assert.assertTrue(new PayBillPage().confirmatonMessage.isDisplayed());
    }
    @Then("Verify {string} alert should be displayed for not enter {string}")
    public void verify_alert_should_be_displayed_for_not_enter(String expectedMessage, String name) {
        waitFor(3);
        String actualMessage=Driver.get().findElement(By.name(name)).getAttribute("validationMessage");
        System.out.println("Message "+actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Then("verify the user cant enter {string} characters in {string} field")
    public void verify_the_user_cant_enter_characters_in_field(String characters, String field) {
     PayBillPage payBillPage =new PayBillPage();
     String ser="";
     if (field.equalsIgnoreCase("amount")){
         try {
             waitFor(2);
             payBillPage.inputAmount.sendKeys(characters);
             waitFor(2);
             ser=payBillPage.inputAmount.getAttribute("value");
             Assert.assertEquals("",ser);
         }catch(Exception e){
             System.out.println("EXCEPTION "+e.getMessage());
         }

     }else if (field.equalsIgnoreCase("date")){
         try {
             waitFor(2);
             payBillPage.dateText.sendKeys(characters);
             waitFor(2);
             ser=payBillPage.dateText.getAttribute("value");
             waitFor(2);
             Assert.assertEquals("",ser);
         }catch(Exception e){
             System.out.println("EXCEPTION "+e.getMessage());
         }
     }
        System.out.println("FIELD "+field+" CHAR "+characters+"Value "+ser);
    }
}
