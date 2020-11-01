package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath="//button[@id=\"signin_button\"]")
    public WebElement buttonSignIn;

    @FindBy(xpath="//input[@id=\"user_login\"]")
    public WebElement userNameLogIn;

    @FindBy(xpath="//input[@id=\"user_password\"]")
    public WebElement passwordLogIn;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement buttonLogIn;

    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement invalidSignInMessage;

}
