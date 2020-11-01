package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public WebElement headMenuPath(String string) {
        string =string.toLowerCase();
        string=string.replaceAll(" ","_");
        String path="//ul[@class='nav nav-tabs']/li[@id='"+string+"_tab']";
        WebElement element= Driver.get().findElement(By.xpath(path));
        return element;
    }
    public String getJsAlertText() {
        Object txt = ((JavascriptExecutor)Driver.get()).executeScript("return window.alert.myAlertText;");
        return (String)txt;
    }
    public Boolean dateCompare(String date, String minBorder, String maxBorder){

        int yearBorderMin=Integer.parseInt(minBorder.substring(0,4));
        int yearBorderMax=Integer.parseInt(maxBorder.substring(0,4));
        int yearDate=Integer.parseInt(date.substring(0,4));

        int monthBorderMin=Integer.parseInt(minBorder.substring(5,7));
        int monthBorderMax=Integer.parseInt(maxBorder.substring(5,7));
        int monthDate=Integer.parseInt(date.substring(5,7));

        int dayBorderMin=Integer.parseInt(minBorder.substring(8,10));
        int dayBorderMax=Integer.parseInt(maxBorder.substring(8,10));
        int dayDate=Integer.parseInt(date.substring(8,10));

        if (yearDate>yearBorderMax || yearDate<yearBorderMin){
            return false;
        }else if (monthDate>monthBorderMax || monthDate<monthBorderMin) {
            return false;
        }else if(dayDate>dayBorderMax || dayDate<dayBorderMin){
            return false;
        }
        return true;
    }
    public  List<String> sortedByRecentDates(List<String> list) {
        List<String> alist=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            alist.add(list.get(i).replaceAll("-",""));
        }
        alist=sortBigtoSmall(alist);
        List<String> aalist=new ArrayList<>();
        for (int i = 0; i < alist.size(); i++) {
            aalist.add(alist.get(i).substring(0, 4) + "-" + alist.get(i).substring(4, 6) + "-" + alist.get(i).substring(6, 8));
        }
        return aalist;
    }

    public  List<String> sortBigtoSmall(List<String> list){
        int [] array=new int [list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i]=Integer.parseInt(list.get(i));
        }
        for (int i=0; i<array.length;i++) {
            for (int j=i; j<array.length;j++) {
                if (array[i]<array[j]) {
                    int t=0;
                    t=array[i];
                    array[i]=array[j];
                    array[j]=t;
                }
            }
        }
        List<String> newList=new ArrayList<>();
        for (int k = 0; k < array.length; k++) {
            newList.add(Integer.toString(array[k]));
        }
        return newList;
    }
    public  Boolean containsNumeric(String str){
        for (int i = 0; i <10; i++) {
            if (str.contains(Integer.toString(i))) {
                return true;
            }
        }
        return false;
    }

}