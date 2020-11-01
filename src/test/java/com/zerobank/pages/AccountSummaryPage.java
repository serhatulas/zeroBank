package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {
    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//table[@class='table'])[3]//thead/tr/th")
    public List<WebElement> creditAccountTable;



    public WebElement linkText(String string) {
        WebElement element=Driver.get().findElement(By.linkText(string));
        return element;
    }
}