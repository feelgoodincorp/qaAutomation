package com.test.PageFragments;

import java.util.List;

import com.test.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSlider{
    WebDriver driver;
    ProductPreview preview;
    WebElement slider;
    WebDriverWait wait;

    private String leftArrowXpath = "//div[@class='collection__next']";
    private String rightArrowXpath = "//div[@class='collection__prev']";
    
    private String productListXpath = "//div[@class='collection__wrapper swiper-wrapper']/*";

    public ProductSlider(WebDriver driver, String sliderName){
        this.driver = driver;
        wait = new WebDriverWait(driver, 1);
        preview = new ProductPreview(driver);
        PageFactory.initElements(driver, this);
        slider = getSlider(sliderName);
    }

    public int getProductsCount(){
        List<WebElement> list = driver.findElements(By.xpath(productListXpath));
        return list.size();
    }

    public boolean isSliderVisible(){
        return slider.isDisplayed();
    }

    public void clickLeftArrow(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.get("leftArrowXpath"))));
            slider.findElement(By.xpath(Locators.get("leftArrowXpath"))).click();
        } catch (Exception e) {
            System.out.println("slider arrow not finded");
        }
    }

    public void clickRightArrow(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rightArrowXpath)));
            slider.findElement(By.xpath(rightArrowXpath)).click();
        } catch (Exception e) {
            System.out.println("slider arrow not finded");
        }
    }

    private WebElement getSlider(String sliderName){
        try{
            Actions action = new Actions(driver);
    
            String a = "//div[contains(text(), 'С этим блюдом заказывают')]/parent::div/parent::div";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '" + sliderName +"')]/parent::div/parent::div")));
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(a)));
            action.moveToElement(driver.findElement(By.xpath("//div[contains(text(), '" + sliderName +"')]/parent::div/parent::div"))).perform();
            return driver.findElement(By.xpath("//div[contains(text(), '" + sliderName + "')]/parent::div/parent::div"));
        }catch(Exception exception){
            System.out.println("slider not founded, exception: " + exception);
            return null;
        }
    }
}