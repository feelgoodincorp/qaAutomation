package com.test;

import java.io.IOException;

import com.test.Tests.ProductPageTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.testng.Reporter;


public class TestManager {

        
        //переделать локаторы под объект(чтоб составлять локаторы между собой)
        //как тогда делать динамические локаторы? объект со строкой
        //TODO Wait только для элементов, которые не отображаются по умолчанию после загрузки страницы
        //TODO переписать все на глобальный wait, принимающий такой же глобальный параметр времени ожидания
        //TODO написать метод ожидания с try catch в нём
        //TODO убрать все FindBy
        //TODO переписать все xpath в файл
        //TODO составить сообщения ошибок
        //TODO использовать assert и softAssert

        //проверка общих элментов всех страниц
        //System.out.println(driver.getTitle());
        //driver.getPageSource().contains("Поиск в Google");
        //объединять элементы одного функционала в один класс(вместо страниц)

        

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

        public static void main(String[] args) throws IOException, InterruptedException {
                
                //driver.get(URL);
                //driver.manage().window().maximize();

                Result result = JUnitCore.runClasses(ProductPageTest.class);					
                for (Failure failure : result.getFailures()) {							
                        System.out.println("failures" + failure.toString());					
                }

                // Request request = Request.method(HeaderTest.class, "logo");
                // Result result = new JUnitCore().run(request);
        
                Reporter.log("Result successful: " + result.wasSuccessful(), true);	
        }
}
