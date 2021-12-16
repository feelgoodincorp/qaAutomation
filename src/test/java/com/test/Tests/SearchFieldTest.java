package com.test.Tests;

import com.test.ConfProperties;
import com.test.Pages.CatalogPage;
import com.test.Pages.HomePage;
import com.test.Pages.ProductPage;
import com.test.Pages.SearchResultPage;

//import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchFieldTest extends Autotest{

    //write wich test is failed
    public static WebDriver driver;
    public static HomePage homePage;
    public static CatalogPage catalogPage;
    public static SearchResultPage searchResultPage;
    public static ProductPage productPage;

    @DisplayName("locations list")
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
}