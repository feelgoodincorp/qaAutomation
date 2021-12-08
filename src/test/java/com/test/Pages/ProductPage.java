package com.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFragments.Header;
import PageFragments.ProductPreview;
import PageFragments.ProductSlider;

public class ProductPage extends Page{
    
    //use wait only for non-static, not acceptable by default, elements
    //all errors should be described in test-classes

    public Header header;
    public ProductPreview productPreview;
    public ProductSlider productSlider;

    WebDriverWait wait;

    //private String itemPriceClass = "item__price item__price_main";
    private String priceXpath = "//div[@class='item__price item__price_main']";
    private String toFavButtonXpath = "//button[@class='item__wishlist card__item-like ']";
    private String increaseButtonXpath = "//button[@class='counter__plus']";
    private String decreaseButtonXpath = "//button[@class='counter__minus']";
    private String toBasketButtonId = "button-cart";
    
    @FindBy(className = "item__title") protected WebElement itemTitle;
    @FindBy(className = "item__price item__price_main") protected WebElement itemPrice;
    //@FindBy(xpath = "/html/body/main/div[2]/div[1]/div[3]/div[5]") protected WebElement itemPrice;

    public ProductPage(WebDriver driver){
        super(driver);
        header = new Header(driver);
        productPreview = new ProductPreview(driver);
        productSlider = new ProductSlider(driver, "Вы недавно смотрели");
        wait = new WebDriverWait(driver, 1);
    }

    public String getProductTitle(){
        return itemTitle.getText();
    };

    public void clickAddToFavorites(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toFavButtonXpath)));
            driver.findElement(By.xpath(toFavButtonXpath)).click();
        } catch (Exception e) {
            System.out.println("cant click fav btn");
        }
    }

    public void clickAddToBasket(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(toBasketButtonId)));
            driver.findElement(By.id(toBasketButtonId)).click();
        } catch (Exception e) {
            System.out.println("to basket button not founded, non clickable");
        }
    }

    public void clickIncreaseQuantity(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(increaseButtonXpath)));
            driver.findElement(By.xpath(increaseButtonXpath)).click();
        } catch (Exception e) {
            System.out.println("cant click increase btn");
        }
    }

    public void clickDecreaseQuantity(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(decreaseButtonXpath)));
            driver.findElement(By.xpath(decreaseButtonXpath)).click();
        } catch (Exception e) {
            System.out.println("cant click decrease btn");
        }
    }

    public void setSizeSelect(int number){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='item__select-wrapper']")));
            if (this.driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor)driver).executeScript("$('#input-option6').prop('selectedIndex', " + number + ").selectric('refresh');");
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }
        } catch (Exception e) {
            System.out.println("cant choose product size");
        }
    }

    public void setSizeSelect(String selectContains){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='item__select-wrapper']")));
            if (this.driver instanceof JavascriptExecutor) {
                //$('#input-option6').val("40 см 0.5 (115 ₴)").change().selectric('refresh');
                ((JavascriptExecutor)driver).executeScript("$('#input-option6').val('" + selectContains+ "').change().selectric('refresh');");
            } else {
                throw new IllegalStateException("This driver does not support JavaScript!");
            }
        } catch (Exception e) {
            System.out.println("cant choose product size");
        }
    }

    public void openSizeSelect(){
        if (this.driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("$('.selectric').selectric('open');");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
    }

    public void closeSizeSelect(){
        if (this.driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("$('.selectric').selectric('close');");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }    
    }

    public String getPrice(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceXpath)));
            return driver.findElement(By.xpath(priceXpath)).getText().replaceAll("[^\\d]","");
        } catch (Exception e) {
            System.out.println("price not founded");
            return null;
        }
    }

    //
}
