package com.test.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public abstract class Page {

    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    WebElement getElement(By locator, Wait wait){
        try {
            wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(locator), 
                ExpectedConditions.visibilityOfElementLocated(locator)
            ));
            return driver.findElement(locator);
         } catch (Exception e) {
            return null;
         }
    };

    WebElement getElement(By byLocator){
        return driver.findElement(byLocator);
    }

    List <WebElement> getElements(By byParentLocator){
        return driver.findElements(byParentLocator);
    }
}
