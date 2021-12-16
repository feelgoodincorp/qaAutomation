package com.test.PageFragments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fragment{

    WebDriver driver;
    WebDriverWait wait;

    public Fragment(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
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