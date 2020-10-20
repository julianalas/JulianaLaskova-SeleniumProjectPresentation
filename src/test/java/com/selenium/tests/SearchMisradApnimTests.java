package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SearchMisradApnimTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.navigate().to("https://www.gov.il/");
    }

    @Test
    public void searchMisradFromNavMenuTest() throws InterruptedException {
        //click on Kabalat Kahal
        click(By.cssSelector("#tm-4"));

        // get page title
       String pageTitle = wd.findElement(By.cssSelector("h1")).getText();
       System.out.println(pageTitle);

       //click on MisradBoxButton

       click(By.cssSelector("[class='icon-arrow-down']"));

       //click on MisradName -  רשות האוכלוסין וההגירה

        click(By.cssSelector("[val='רשות האוכלוסין וההגירה']"));

        //click on Yeshuv

        click(By.cssSelector("#city"));

        //click on Jerusalem

        click(By.cssSelector("[value='f2c16b0e-4469-417a-b8a2-b9583f6f676a']"));

        //click on JerusalemMerkaz

        Thread.sleep(3000);

        click(By.cssSelector("#heading6 [href='#collapseItem6']"));

        // get address of MisradName

        Thread.sleep(3000);

        String addressMisradName = wd.findElement(By.xpath("//span[text()='שלומציון המלכה ']")).getText();
        System.out.println("כתובת: " + addressMisradName);

    }

    @Test
    public void searchMisradFromSiteSearchBox(){
        //click on SiteSearchBox
        click(By.cssSelector("#SearchInput"));
        String searchName = "רשות האוכלוסין וההגירה במרכז ירושלים";
        type(By.cssSelector("#SearchInput"), searchName);
        click(By.cssSelector("[class='hicon-search']"));

        //click on MisradName
        click(By.cssSelector("[href='https://www.gov.il/he/Departments/Bureaus/jerusalem_central_piba']"));

        // get address of MisradName

        String addressMisradName = wd.findElement(By.cssSelector("li [name='Address']")).getText();
        System.out.println("כתובת: " + addressMisradName);

    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        if(text!=null) {
            wd.findElement(locator).sendKeys(text);
        }
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }


}

/*
שאלות:
1. צור פרויקט מסוג UnitTest , השתמש ב- Selenium לכתיבה והרצה של הבדיקות על דפדפן
Chrome בהתאם לדרישות המפורטות מטה:
a . גלישה לאתר https://www.gov.il/
b . כתוב פונקציות לחיפוש לשכת רשות האוכלוסין במרכז ירושלים ב- 2 אפשרויות
חיפוש, על הפונקציה להיות במבנה גנרי ששמתאים לחיפוש כל לשכה באתר:
• חיפוש לשכה לפי טקסט ברכיב החיפוש הכללי באתר
• חיפוש לשכה ע"י מילוי השדות שברכיב הסינון בטאב קבלת קהל
c . עבור לדף הלשכה ובדוק שהגעת ללשכה הרצויה
2. כתוב עץ בדיקות ידניות לרכיב השפות שבאתר https://www.gov.il/
3. כתוב עץ בדיקות ידניות לרכיב אימות זהות שבטופס ההרשמה למערכת ההזדהות

Вопросы:
1. Создайте проект UnitTest, используйте Selenium для написания и запуска тестов в браузере Crome
в соответствии с требованиями ниже:
а. Перейдите на сайт https://www.gov.il/
б. Напишите функции для поиска Бюро Управления народонаселения в центре Иерусалима в 2 вариантах
Поиск, функция должна иметь общую структуру, которая соответствует поиску каждого бюро на сайте:
• Поиск бюро по тексту в общем поисковом компоненте сайта.
• Найдите бюро, заполнив поля в компоненте фильтрации на вкладке «Квитанция аудитории».
c. Перейдите на страницу бюро и убедитесь, что вы прибыли в желаемое бюро.
2. Напишите мануал тестов для языковой составляющей на сайте https://www.gov.il/
3. Напишите дерево ручной проверки для компонента проверки личности в регистрационной форме для системы идентификации

* */
