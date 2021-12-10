package com.test.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//ожидания и xpath в конфиг?
//в страницах - её объекты
//в тестах - методы самих тестов
//для тестирования корзины - несколько объектов страниц


//page and interact methods
public class SearchResultPage{

    WebDriver driver;
    final WebDriverWait wait;
    
    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 2);
    }

    public boolean isItemExists(String itemName){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product__title'][text() = '" + itemName + "']")));
            return true;
        } catch (Exception e) {
            System.out.println("item not founded");
            return false;
        }
    }

    public void clickResultItem(int index){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='catalog__item']")));
            List<WebElement> results = driver.findElements(By.xpath("//div[@class='catalog__item']"));
            if(index<=results.size()){
                results.get(index).click();
            }
        } catch (Exception e) {
            System.out.println("out of finded results quantity");
        }
    }

    public void clickPagination(int index){

    }

    public void changePage(){

    }
}