package PageFragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPreview {

    WebDriver driver;
    WebDriverWait wait;
    
    private String priceXpath = "//div[@class='item__price item__price_main']";
    private String toFavButtonXpath = "//button[@class='product__wishlist card__item-like ']";
    private String toBasketButtonXPath = "//button[@class='add-to-cart product__add']";
    private String toItemPageButtonXpath = "//a[@class='product__title']";

    @FindBy(className = "item__title") protected WebElement itemTitle;
    @FindBy(className = "item__price item__price_main") protected WebElement itemPrice;
    
    public ProductPreview(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 1);
        this.driver = driver;
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toBasketButtonXPath)));
            driver.findElement(By.xpath(toBasketButtonXPath)).click();
        } catch (Exception e) {
            System.out.println("to basket button not founded, non clickable");
        }
    }

    public String getProductTitle(){
        return itemTitle.getText();
    };

    public void clickProductTitle(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toItemPageButtonXpath)));
            driver.findElement(By.xpath(toItemPageButtonXpath)).click();
        } catch (Exception e) {
            System.out.println("item button not founded, non clickable");
        }
    }
}
