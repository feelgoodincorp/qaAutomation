package com.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFragments.Header;

public class CatalogPage{

    WebDriver driver;
    CatalogPage page;
    public Header header;
    WebDriverWait wait;

    final String desktopMenuListClass = "navigation__list navigation__list--desktop";

    public CatalogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        header = new Header(driver);
        wait = new WebDriverWait(driver, 5);
        this.driver = driver;
    }

    @FindBy(className = "catalog__title") protected WebElement element;

    public String getPageName(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("catalog__title")));
            return driver.findElement(By.className("catalog__title")).getText();
        } catch (Exception e) {
            System.out.println("title of page not founded");
            return null;
        }
    }

    // public void clickOnDesktopMenuButton(String buttonName){
    //     try {
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='" + desktopMenuListClass + "']/li/a[text() = '" + buttonName + "']")));
    //     } catch (Exception e) {
    //         System.out.println("menu button not founded");
    //     }
    // }

    // public WebElement getMenuList(){
    //     try {
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='" + desktopMenuListClass + "']")));
    //         return driver.findElement(By.xpath("//ul[@class='" + desktopMenuListClass + "']"));
    //     } catch (Exception e) {
    //         System.out.println("buttons list not founded");
    //         return null;
    //     } 
    // }
}