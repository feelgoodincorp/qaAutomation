package com.test.Tests;

import com.test.ConfProperties;
import com.test.Pages.ProductPage;
import com.test.Pages.SearchResultPage;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ProductPageTest extends Autotest{
    
    public static ProductPage productPage;
    public static SearchResultPage searchResultPage;
    //public String pageUrl = ConfProperties.get("productpage");
    public String pageUrl = ConfProperties.get("mainpage");

    
    @Test
    @DisplayName("check logo clickability")
    public void test() {

        //сначала открытие страницы, потом все конструкторы(т.к. в них могут создаваться объекты страницы)
        //не нужно вынести это все в прекондишн???
        //можно вынести создание страниц в инит
        driver.get(pageUrl);
        productPage = new ProductPage(driver);
        searchResultPage = new SearchResultPage(driver);

        

        
        //assertTrue(productPage.isInitialized());

        // try {
        //     System.err.println(productPage.productPreview == null); 
        // } catch (Exception e) {
        //     System.out.println(e.toString());
        // }

        // final String toBasketButtonXPath = "//button[@class='add-to-cart product__add']";
        // WebElement element = driver.findElement(By.xpath(toBasketButtonXPath));
        // Actions actions = new Actions(driver);
        // actions.moveToElement(element);
        // actions.perform();
        
        //productPage.productPreview.clickAddToBasket();
        
        //productPage.setSizeSelect(1);
        //productPage.setSizeSelect("40 см 0.5 (115 ₴)");
        //productPage.clickIncreaseQuantity();
        //productPage.clickDecreaseQuantity();
        //productPage.clickAddToBasket();

        //count in slider
        //System.out.println(productPage.productSlider.getProductsCount());

        //System.out.println(Locators.getLocator("logoBtnClass"));


        // productPage.header.writeSearchRequest(ConfProperties.get("nonExistingItemNameRU"));
        // System.err.println("isNoResultsMessageDisplayed: " + productPage.header.isNoResultsMessageDisplayed());
        // System.err.println("isResultsDisplayed: " + productPage.header.isResultsDisplayed());

        // productPage.header.searchClear();
        // productPage.header.writeSearchRequest(ConfProperties.get("existingItemNameRU"));
        // System.err.println("isNoResultsMessageDisplayed: " + productPage.header.isNoResultsMessageDisplayed());
        // System.err.println("isResultsDisplayed: " + productPage.header.isResultsDisplayed());
        

        //productPage.header.searchClear();
        //productPage.header.writeSearchRequest(ConfProperties.get("existingItemNameRU"));
        //productPage.header.writeSearchRequest("пицца");
        //productPage.header.clickResultItem(5);

        //Assert.fail("element by locator " + byLocator + " is not finded");
    
        // searchResultPage.clickResultItem(1);
        // try {
        //     Thread.sleep(4000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // productPage.clickAddToBasket();

        // productPage.header.writeSearchRequest("пицца");
        // productPage.header.searchSubmit();
        // searchResultPage.clickResultItem(1);
        // productPage.clickAddToBasket();

        // productPage.header.writeSearchRequest("пицца");
        // productPage.header.searchSubmit();
        // searchResultPage.clickResultItem(1);
        // productPage.clickAddToBasket();

        // productPage.header.writeSearchRequest("пицца");
        // productPage.header.searchSubmit();
        // searchResultPage.clickResultItem(1);
        // productPage.clickAddToBasket();

        //productPage.productSlider.clickLeftArrow();
   }

}
