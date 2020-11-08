package com.selenium.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchMisradApnimTests extends TestBase{

    @Test
    public void searchMisradByFilterFieldsTest() throws InterruptedException {
        app.getHomePage().selectKabalatKahalFromNavMenuOfHomePage();
        app.getFilterFields().selectMisradNameFromDropDownList();
        app.getFilterFields().selectCityNameFromDropDownList();
        app.getFilterFields().pause(3000);
        app.getFilterFields().selectAreaNameOfCity();

        app.getFilterFields().pause(3000);
        String addressOfFoundMisradByFilterFields = app.getFilterFields().getAddressOfFoundMisradByFilterFields();
        Assert.assertEquals(addressOfFoundMisradByFilterFields, "שלומציון המלכה 1, ירושלים");
        System.out.println("כתובת: " + addressOfFoundMisradByFilterFields);

    }

    @Test
    public void searchMisradFromSiteSearchBoxTest(){
        app.getHomePage().searchForMisradByTextInSearchBoxOfHomePage();
        app.getGeneralStrategy().searchMisradNameFromListOfSimilarNames();

        String addressMisradFromSiteSearch = app.getGeneralStrategy().getAddressOfFoundMisradByGeneralSearchStrategy();
        Assert.assertEquals(addressMisradFromSiteSearch, "שלומציון המלכה 1, רושלים");
        System.out.println("כתובת: " + addressMisradFromSiteSearch);



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
