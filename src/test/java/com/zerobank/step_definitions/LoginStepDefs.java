package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static com.zerobank.utilities.BrowserUtils.waitFor;

public class LoginStepDefs  {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().manage().window().maximize();
        Driver.get().get(url);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        LoginPage loginPage =new LoginPage();
        loginPage.buttonSignIn.click();
        waitFor(3);
        loginPage.userNameLogIn.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordLogIn.sendKeys(ConfigurationReader.get("password"));
        loginPage.buttonLogIn.click();
    }

    @When("users should be able to login to the application")
    public void users_should_be_able_to_login_to_the_application() {
        waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero – Account summary", actualTitle);
    }

    @When("user logs in with invalid credentials,")
    public void user_logs_in_with_invalid_credentials() {
        LoginPage loginPage =new LoginPage();
        loginPage.buttonSignIn.click();
        waitFor(3);
        loginPage.buttonLogIn.click();

    }
    
    @Then("Login and\\/or password are wrong, should be displayed")
    public void login_and_or_password_are_wrong_should_be_displayed() {
        waitFor(3);
        String actualTitle = new LoginPage().invalidSignInMessage.getAttribute("innerHTML");
        actualTitle=actualTitle.trim();
        Assert.assertEquals("Login and/or password are wrong.", actualTitle);
    }


}
