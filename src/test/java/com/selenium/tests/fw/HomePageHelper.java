package com.selenium.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase{

    public HomePageHelper(WebDriver wd) {
        super(wd);
    }

    public void searchForMisradByTextInSearchBoxOfHomePage() {
        //click on SearchBoxHomePage
        String searchName = "רשות האוכלוסין וההגירה במרכז ירושלים";
        type(By.cssSelector("#SearchInput"), searchName);
        click(By.cssSelector("[class='hicon-search']"));
    }

    public void selectKabalatKahalFromNavMenuOfHomePage() {
        //click on Kabalat Kahal
        click(By.cssSelector("#tm-4"));
        // get page title
        String pageTitle = wd.findElement(By.cssSelector("h1")).getText();
        System.out.println(pageTitle);
    }



}
