package com.test.Tests;

import java.util.concurrent.TimeUnit;

import com.test.ConfProperties;
import com.test.Pages.SearchResultPage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SearchTest{

    public static WebDriver driver;
    public static SearchResultPage page;
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.get("chromedriver"));

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-sandbox");
        
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().window().setPosition(new Point(1800,0));
        driver.get(ConfProperties.get("mainpage"));

        page = new SearchResultPage(driver);
    }
    
        //десктоп:
        //проверка на открытие при вводе текста, скрытии при удалении
        //проверка на открытие существующих товаров
        //проверка на соответствие товаров в подсказках тем, которые на странице результатов
        //проверка на закрытие
        //проверка на редирект на страницу результатов
        //проверка на редирект на страницу товара
        //проверка на наличие элементов? битость картинки, не ноль названия, наличие кнопки, текста если не найдено
        //проверка стилей всех элементов?
        //проверка на двух языках
        //проверка на отображение только либо товаров либо сообщения о несуществующих результатах

        


    @Test
    public void run(){
        //page.writeRequest("request");
    }

    //all same tests, but on all versions
    @Test
    public void onDifferentLanguages(){
        // page.changeLanguage("ru");
        // this.run();
        // page.changeLanguage("en");
        // this.run();
    }

    @AfterClass
    public static void tearDown(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }



    //sub-methods
    //check: default state(closed, empty)
    //check: search prompt appropriates request text
    //check: different languages

    //check: 
}