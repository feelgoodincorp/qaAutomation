package com.test.Tests;

import com.test.ConfProperties;
import com.test.Pages.ProductPage;
import com.test.Pages.SearchResultPage;

import org.junit.Test;

public class ProductPageTest extends Autotest{
    
    public static ProductPage productPage;
    public static SearchResultPage searchResultPage;
    public String pageUrl = ConfProperties.get("productpage");
    //public String pageUrl = ConfProperties.getProperty("mainpage");

    @Test
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


        //lot of waits as temporary solution
        productPage.header.writeSearchRequest(ConfProperties.get("nonExistingItemNameRU"));
        System.err.println(productPage.header.isSearchResultFounded());
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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


    // @BeforeClass
    // public static void setup() {
    //     System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

    //     ChromeOptions chromeOptions = new ChromeOptions();
    //     //chromeOptions.addArguments("--headless");
    //     //chromeOptions.addArguments("--no-sandbox");
        
    //     driver = new ChromeDriver(chromeOptions);
    //     driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    //     driver.manage().window().setSize(new Dimension(1024,768));
    //     driver.manage().window().setPosition(new Point(1800,0));
    //     driver.manage().deleteAllCookies();
    //     driver.get(ConfProperties.getProperty("mainpage"));
    //     productPage = new ProductPage(driver);
    // }

    // @Test
    // public void isPriceShown(){
    //     System.out.println("text");
    // }

    // @AfterClass
    // public static void tearDown() {
    //     // TODO Auto-generated method stub
        
    // }
}
