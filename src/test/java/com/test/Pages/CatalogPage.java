package com.test.Pages;

import com.test.PageFragments.Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends Page{

    public CatalogPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        header = new Header(driver);
        wait = new WebDriverWait(driver, 5);
        this.driver = driver;
    }

    WebDriver driver;
    CatalogPage page;
    public Header header;
    WebDriverWait wait;

    final String desktopMenuListClass = "navigation__list navigation__list--desktop";

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


//     //uses for dynamic, accessable after some events elements
//     private WebElement getElement(By byLocator, Wait wait){
//         try {
//            wait.until(ExpectedConditions.and(
//                ExpectedConditions.presenceOfElementLocated(byLocator), 
//                ExpectedConditions.visibilityOfElementLocated(byLocator)
//            ));
//            return driver.findElement(byLocator);
//         } catch (Exception e) {
//            return null;
//         }
//    }

//    private List <WebElement> getElements(By byParentLocator){
//        return driver.findElements(byParentLocator);
//    }
}