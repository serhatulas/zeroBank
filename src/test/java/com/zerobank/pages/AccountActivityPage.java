package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement accountIdSelect;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[1]")
    public WebElement savingsSelect;

    @FindBy(xpath ="//div[@id='all_transactions_for_account']//th")
    public List<WebElement> transactionsTable;

    @FindBy(xpath ="//div[@id='all_transactions_for_account']//th[1]")
    public WebElement transactionsTable1;

    @FindBy(xpath ="//input[@id='aa_fromDate']")
    public WebElement datesFindTransactionFromInput;

    @FindBy(xpath ="//input[@id='aa_toDate']")
    public WebElement datesFindTransactionToInput;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath ="//div[@id='filtered_transactions_for_account']/table//td[contains(text(),'-')]")
    public List<WebElement> dateTableFindTransaction;

    @FindBy(id="aa_description")
    public WebElement descriptionTextBox;

    @FindBy(xpath="(//div[@id='filtered_transactions_for_account']//td)[2]")
    public WebElement descriptionTableRow;

    @FindBy(xpath="(//div[@id='filtered_transactions_for_account']//td)[3]")
    public WebElement depositTableRow;

    @FindBy(xpath="(//div[@id='filtered_transactions_for_account']//td)[4]")
    public WebElement withdrawalTableRow;

    @FindBy(id="aa_type")
    public WebElement typeSelect;


    public WebElement accountIdSelect(String string) {
       String path="//select[@id='aa_accountId']/option[.='"+string+"']";
       WebElement element=Driver.get().findElement(By.xpath(path));
       return element;
    }
    public WebElement getCellElementByIndex(int row, int column){
         String table="((//table[@class='table table-condensed table-hover'])[2]//tr)["+row+"]/td["+column+"]";
        return  Driver.get().findElement(By.xpath(table));
    }
    public int getnumberOfRowsWithHeadFromTable(){
        String table="((//table[@class='table table-condensed table-hover'])[2]//tr)";
        List<WebElement> sizeOfRows = Driver.get().findElements(By.xpath(table));
        return  sizeOfRows.size();
    }
    public int getnumberOfColumnsFromTable(){
        String table="((//table[@class='table table-condensed table-hover'])[2]//th)";
        List<WebElement> sizeOfColumns = Driver.get().findElements(By.xpath(table));
        return  sizeOfColumns.size();
    }
}
