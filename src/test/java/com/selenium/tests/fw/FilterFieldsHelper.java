package com.selenium.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterFieldsHelper extends HelperBase{


    public FilterFieldsHelper(WebDriver wd) {
        super(wd);
    }

    public void selectCityNameFromDropDownList() {
        //click on Yeshuv
        click(By.cssSelector("#city"));
        //click on Jerusalem
        click(By.cssSelector("[value='f2c16b0e-4469-417a-b8a2-b9583f6f676a']"));
    }

    public void selectMisradNameFromDropDownList() {
        //click on MisradBoxButton
        click(By.cssSelector("[class='icon-arrow-down']"));
        //click on MisradName -  רשות האוכלוסין וההגירה
        click(By.cssSelector("[val='רשות האוכלוסין וההגירה']"));
    }

    public void selectAreaNameOfCity()  {
        //click on JerusalemMerkaz
        click(By.cssSelector("#heading6 [href='#collapseItem6']"));
    }

    public String getAddressOfFoundMisradByFilterFields() {
        return wd.findElement(By.xpath("//span[text()='שלומציון המלכה ']")).getText();
    }

}
