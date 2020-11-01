package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class PayBillPage extends BasePage {
    public PayBillPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id ="sp_payee")
    public WebElement payeeSelect;

    @FindBy(id="sp_account")
    public WebElement accountSelect;

    @FindBy(xpath="//input[@type='text' and @name='amount']")
    public WebElement inputAmount;

    @FindBy(id="sp_description")
    public WebElement descriptionText;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement payButton;

    @FindBy(id="sp_date")
    public WebElement dateText;

    @FindBy(xpath="(//a[@class='ui-state-default'])[5]")
    public WebElement calender;

    @FindBy(xpath="//span[@title='$ 10000 payed to payee apple']")
    public WebElement confirmatonMessage;

    @FindBy(xpath="(//script[@type='text/javascript'])[4]")
    public WebElement javaMessage;

    @FindBy(id="np_new_payee_name")
    public WebElement newPayeeName;

    @FindBy(id="np_new_payee_address")
    public WebElement newPayeeAdress;

    @FindBy(id="np_new_payee_account")
    public WebElement newPayeeAccount;

    @FindBy(id="np_new_payee_details")
    public WebElement newPayeeDetails;

    @FindBy(id="add_new_payee")
    public WebElement newPayeeAddButton;

    @FindBy(id="alert_content")
    public WebElement newPayeeConfirmationText;

    @FindBy(xpath="//select[@name=\"currency\"]")
    public WebElement foreignCurrencySelect;

    @FindBy(xpath="//input[@value='Purchase']")
    public WebElement purchaseButton;

    @FindBy(xpath="(//input[@type='radio'])[2]")
    public WebElement currencyRadioButton;

}
