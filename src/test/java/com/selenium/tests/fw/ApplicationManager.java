package com.selenium.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    FilterFieldsHelper filterFields;
    GeneralSearchStrategyHelper generalStrategy;
    HomePageHelper homePage;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if(browser.equals(BrowserType.FIREFOX))  {
            wd = new FirefoxDriver();
        } else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        } else if(browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.navigate().to("https://www.gov.il/");

        homePage = new HomePageHelper(wd);
        filterFields = new FilterFieldsHelper(wd);
        generalStrategy = new GeneralSearchStrategyHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public FilterFieldsHelper getFilterFields() {
        return filterFields;
    }

    public GeneralSearchStrategyHelper getGeneralStrategy() {
        return generalStrategy;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }
}
