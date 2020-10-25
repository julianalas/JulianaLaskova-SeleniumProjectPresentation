package com.selenium.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralSearchStrategyHelper extends HelperBase{

    public GeneralSearchStrategyHelper(WebDriver wd) {
        super(wd);
    }

    public void searchMisradNameFromListOfSimilarNames() {
        //click on MisradName
        click(By.cssSelector("[href='https://www.gov.il/he/Departments/Bureaus/jerusalem_central_piba']"));
    }

    public String getAddressOfFoundMisradByGeneralSearchStrategy() {
        return wd.findElement(By.cssSelector("li [name='Address']")).getText();

    }
}
