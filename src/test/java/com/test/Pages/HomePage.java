package com.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFragments.Header;

public class HomePage {
    WebDriver driver;
    public Header header;
    final WebDriverWait wait;

    public HomePage(WebDriver driver){
        header = new Header(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    //use one WebDriverWait for all elements

    //element is not shown after load, so is allways be not finded


    //mini item's card
    public void clickAddToFavorites(){

    }

    public void clickAddToBasket(){

    }

    

    // public WebElement getMenuList(){
    
    //     try {
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='" + desktopMenuListClass + "']")));
    //         return driver.findElement(By.xpath("//ul[@class='" + desktopMenuListClass + "']"));
    //     } catch (Exception e) {
    //         System.out.println("buttons list not founded");
    //         return null;
    //     } 
    // }

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
