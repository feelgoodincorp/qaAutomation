package com.test.PageFragments;

import java.util.List;

import com.test.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends Fragment{

    final WebDriverWait wait;

    public Header(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 5);
    }

    //menu
    public void clickOnDesktopMenuButton(String buttonName){
        getElement(new By.ByXPath(Locators.get("desktopMenuListClass") + "[text() = '" + buttonName + "']")).click();
    }

    //logo
    public void clickLogo(){
        getElement(new By.ByClassName(Locators.get("logoBtnClass"))).click();
    }

    public boolean isLogoClickable(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(getElement(new By.ByXPath(Locators.get("logoXpath")))));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //search
    public void writeSearchRequest(String text){
        getElement(new By.ByName(Locators.get("searchFieldName"))).sendKeys(text);
    }

    public void searchResultItemClick(){
        getElement(new By.ByName(Locators.get("searchFieldName"))).click();
    }
    
    //getSearchResults
    //isResultsDisplayed
    //isNoResultsMessageDisplayed
    //не проверять отображение livesearch

    public boolean isNoResultsMessageDisplayed(){
        WebElement element = getElement(new By.ByXPath(Locators.get("noSearchResultText")), wait);
        return element != null ? element.isDisplayed() : false;
    }
    
    public boolean isResultsDisplayed(){
        try {
            WebElement element = getElement(new By.ByXPath(Locators.get("searchResultItemXpath")), wait);
            return element != null ? element.isDisplayed() : false;
        } catch (StaleElementReferenceException e) {
            //another try-catch for elements, wich can be recreated many times per one calling(reactive elements?)
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(new By.ByXPath(Locators.get("searchResultItemXpath"))));
            } catch (Exception ex) {
                return true;
            }
            WebElement element = getElement(new By.ByXPath(Locators.get("searchResultItemXpath")), wait);
            return element != null ? element.isDisplayed() : false;
        }
    }
    
    public void clickResultItem(int index){
        scrollToElement(getSearchResults(5).get(index));
        getSearchResults(5).get(index).click();
    }
    
    //should wait definite time, so have own waiter
    private List<WebElement> getSearchResults(long maxLoadingTime){
        final WebDriverWait wait = new WebDriverWait(driver, maxLoadingTime);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.get("searchResultLinkXpath"))));
            return getElements(new By.ByXPath(Locators.get("searchResultLinkXpath")));
        } catch (Exception e) {
            return null;
        }
    }


    public void allResultsClick(){
        getElement(new By.ByXPath(Locators.get("allResultsButtonXpath")), wait).click();
        System.err.println("click success");
    }

    public void searchSubmit(){
        getElement(new By.ByName(Locators.get("searchFieldName"))).submit();
    }

    public void searchClear(){
        getElement(new By.ByName(Locators.get("searchFieldName"))).clear();
    }

    //locations
    public boolean isLocationsVisible(){
        return getElement(new By.ByXPath(Locators.get("locationListXpath")), wait).isDisplayed();
    }

    public boolean isLocationsInvisible(){
        return !getElement(new By.ByXPath(Locators.get("locationListXpath")), wait).isDisplayed();
    }

    public void locationsClick(){
        getElement(new By.ByXPath(Locators.get("locationListXpath"))).click();
    }

    //phones
    public boolean isPhonesVisible(){
        return getElement(new By.ByXPath(Locators.get("phoneListXpath")), wait).isDisplayed();
    }

    //can delete?
    public boolean isPhonesInvisible(){
        return !getElement(new By.ByXPath(Locators.get("phoneListXpath")), wait).isDisplayed();
    }

    public void phonesCLick(){
        getElement(new By.ByClassName(Locators.get("phonesButtonClass"))).click();
    }


    //lang
    public void changeLang(){
        Actions action = new Actions(driver);
        action.moveToElement(getElement(new By.ByClassName(Locators.get("languageListClass")))).perform();
        getElement(new By.ByXPath(Locators.get("languageButtonXpath"))).click();
    }
    //uses for static, all-time accessable by default elements
    WebElement getElement(By byLocator){
        return driver.findElement(byLocator);
    }

    // //uses for dynamic, accessable after some events elements
    // private WebElement getElement(By byLocator, Wait wait){
    //      try {
    //         wait.until(ExpectedConditions.and(
    //             ExpectedConditions.presenceOfElementLocated(byLocator), 
    //             ExpectedConditions.visibilityOfElementLocated(byLocator)
    //         ));
    //         return driver.findElement(byLocator);
    //      } catch (Exception e) {
    //         return null;
    //      }
    // }

    List <WebElement> getElements(By byParentLocator){
        return driver.findElements(byParentLocator);
    }

    //js scrolls to the max bottom  position of selected element, unlike Selenium Actions
    private void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

