package com.test.Tests;

import java.io.File;
import java.io.IOException;

import com.test.Pages.SearchResultPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends Autotest{

    public static SearchResultPage page;
    
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

    @AfterMethod
    public void screenShot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1, new File("/screenshots/"));
    }





    //sub-methods
    //check: default state(closed, empty)
    //check: search prompt appropriates request text
    //check: different languages

    //check: 
}