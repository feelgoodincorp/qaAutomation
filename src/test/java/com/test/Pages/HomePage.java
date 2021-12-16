package com.test.Pages;

import com.test.Locators;
import com.test.PageFragments.Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page{
    public Header header;
    final WebDriverWait wait;

    public HomePage(WebDriver driver){
        super(driver);
        header = new Header(driver);
        wait = new WebDriverWait(driver, 3);
    }

    public WebElement getMenuList(){    
        try {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='" + Locators.get("desktopMenuListClass") + "']")));
            //попробовать с class
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='" + Locators.get("desktopMenuListClass") + "']")));
            return driver.findElement(By.xpath("//ul[@class='" + Locators.get("desktopMenuListClass") + "']"));
        } catch (Exception e) {
            System.out.println("buttons list not founded");
            return null;
        } 
    }

    // public List<WebElement> getDesktopMenuButtons(){
    //     try {
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='" + desktopMenuListClass + "']")));
    //     } catch (Exception e) {
    //         System.out.println("buttons list not founded");
    //     }
    //     return driver.findElements(By.xpath("//ul[@class='" + desktopMenuListClass + "']"));
    // }

    // //header nav buttons
    // public void clickToButtons(){
    //     //массив элементов, каждый после клика проверяет название кнопки и название страницы
    //     List <WebElement> buttonsList = getDesktopMenuButtons();
    //     System.out.println(buttonsList.size());
    //     ArrayList<String> buttonNames = new ArrayList<>();

    //     for (int i = 0; i < buttonsList.size(); i++) {
    //         buttonNames.add(buttonsList.get(i).getText());
    //     }

    //     System.out.println(buttonNames);
    // }

    public void clickOnBasketQuantity(){

    }

    public void clickOnLogin(){

    }
}
