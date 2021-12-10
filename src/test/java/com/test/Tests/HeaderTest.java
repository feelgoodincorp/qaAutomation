package com.test.Tests;

import com.test.ConfProperties;
import com.test.Pages.CatalogPage;
import com.test.Pages.HomePage;
import com.test.Pages.ProductPage;
import com.test.Pages.SearchResultPage;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


public class HeaderTest extends Autotest{

    //write wich test is failed
    public static WebDriver driver;
    public static HomePage homePage;
    public static CatalogPage catalogPage;
    public static SearchResultPage searchResultPage;
    public static ProductPage productPage;



    //locations list test scenery
    @Test
    public void locationsButton(){
        driver.get(ConfProperties.get("mainpage"));

        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        catalogPage = new CatalogPage(driver);
        productPage = new ProductPage(driver);
        
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(homePage.header.isLocationsVisible(), "location list opened by default.");
        homePage.header.locationsClick();
        softAssert.assertTrue(homePage.header.isLocationsVisible(), "location list not opened after click.");
        homePage.header.locationsClick();
        softAssert.assertTrue(homePage.header.isLocationsInvisible(), "location list not closed after click.");

        softAssert.assertAll();
    }


    //phone numbers list scenery
    @Test
    public void phoneButton(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(homePage.header.isPhonesVisible(), "phone numbers  list opened by default.");
        homePage.header.phonesCLick();
        softAssert.assertTrue(homePage.header.isPhonesVisible(), "phone numbers  list not opened after click.");
        homePage.header.phonesCLick();
        softAssert.assertTrue(homePage.header.isPhonesInvisible(), "phone numbers  list not closed after click.");

        softAssert.assertAll();


    }

    @Test
    public void searchField(){
        SoftAssert softAssert = new SoftAssert();

        String existingItemRequestRu = ConfProperties.get("existingItemNameRU");
        String nonExistingItemRequestRu = ConfProperties.get("nonExistingItemNameRU");
        
        homePage.header.writeSearchRequest(nonExistingItemRequestRu);
        softAssert.assertFalse(homePage.header.isSearchResultFounded(), "error: have finded items");
        homePage.header.searchClear();
        homePage.header.writeSearchRequest(existingItemRequestRu);
        softAssert.assertTrue(homePage.header.isSearchResultFounded(), "error: no founded items");

        homePage.header.searchClear();
        homePage.header.writeSearchRequest(existingItemRequestRu);
        homePage.header.allResultsClick();
        softAssert.assertTrue(searchResultPage.isItemExists(existingItemRequestRu), "error: no founded items");

        homePage.header.searchClear();
        homePage.header.writeSearchRequest(existingItemRequestRu);
        homePage.header.searchResultItemClick();
        softAssert.assertTrue(productPage.getProductTitle().equals(existingItemRequestRu), "error: item's name not the same as in requested and opened");
        softAssert.assertAll();
    }

    // @Test
    // public void desktopMenu(){
    //     String menuItems [] = ConfProperties.getProperty("menuItemsRU").split("\\s*,\\s*");
    //     for (String item : menuItems) {
    //         catalogPage.header.clickOnDesktopMenuButton(item);
    //         //TODO проверку листа меню в соответствии с заголовком(может быть в конфе пары кнопка - url)
    //         //System.out.println(catalogPage.getPageName());
    //         driver.navigate().back();
    //     }
    // }

    // @Test
    // public void logo(){
    //     SoftAssert softAssert = new SoftAssert();
    //     driver.get(ConfProperties.getProperty("mainpage"));
    //     softAssert.assertTrue(catalogPage.header.isLogoClickable(), "");
    //     catalogPage.header.clickOnDesktopMenuButton("Новинки");
    //     System.out.println(catalogPage.header.isLogoClickable());
    //     catalogPage.header.clickLogo();
    // }


    //TODO Test basket and login button


}