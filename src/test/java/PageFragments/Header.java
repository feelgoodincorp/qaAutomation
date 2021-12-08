package PageFragments;

import com.test.Locators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    final WebDriver driver;
    final WebDriverWait wait;
    
    //all element identitys
    // final String desktopMenuListClass = "navigation__list navigation__list--desktop";
    // final String logoClass = "site-logo header__logo header__logo--xl";
    // final String locationListXpath = "/html/body/header/div/div[2]/div[2]/ul";
    // final String locationButtonClass = "header__location";
    // final String phoneListXpath = "/html/body/header/div/div[2]/div[5]/ul";
    // final String phonesButtonClass = "header__phone";
    // final String collapseListClass = "header-collapse__list";
    // final String languageListClass = "language";
    // final String languageButtonXpath = "//ul[@class='language']/li/a";
    // final String searchFieldName = "search";
    // final String searchResultLinkXpath = "//div[@class='live-search']/ul/li/a";
    // final String allResultsButtonXpath = "//div[@class='result-text']/a";

    //default elements
    // @FindBy(xpath = locationListXpath) protected WebElement locationList;
    // @FindBy(xpath = phoneListXpath) protected WebElement phoneList;
    // @FindBy(className = phonesButtonClass) protected WebElement phonesButton;
    // @FindBy(className = collapseListClass) protected WebElement collapseList;
    // @FindBy(className = languageListClass) protected WebElement languageList;
    // @FindBy(xpath = languageButtonXpath) protected WebElement languageButton;
    // @FindBy(name = searchFieldName) protected WebElement searchField;
    // @FindBy(xpath = searchResultLinkXpath) protected WebElement searchResultLink;
    // @FindBy(className = allResultsButtonXpath) protected WebElement allResultsButton;
    // @FindBy(className = locationButtonClass) protected WebElement locationButton;
    // @FindBy(className = logoClass) protected WebElement logo;

    public Header(WebDriver driver){
        //PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    //menu
    public void clickOnDesktopMenuButton(String buttonName){
        getElement(By.xpath("//ul[@class='" + Locators.get("desktopMenuListClass") + "']/li/a[text() = '" + buttonName + "']")).click();
    }

    //logo
    public void clickLogo(){
        getElement(new By.ByClassName(Locators.get("logoBtnClass"))).click();
    }

    public boolean isLogoClickable(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='" + Locators.get("logoBtnClass") + "']")));
        } catch (Exception e) {
            return false;
        }

        try {
            //TODO works, but have to change logic, 
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='" + Locators.get("logoBtnClass") + "']/a")));
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

    public boolean isResultsDisplayed(){
        return getElement(new By.ByClassName(Locators.get("searchResultClass")), wait).isDisplayed();
    }

    public boolean isSearchResultFounded(){
        // final WebDriverWait wait = new WebDriverWait(driver, maxLoadingTime);
        // try {
        //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.get("searchResultLinkXpath"))));
        //     return true;
        // } catch (Exception e) {
        //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='live-search']/ul/li[text() = 'Нет товаров, соответствующих критериям поиска.' or 'Немає товарів, які відповідають критеріям пошуку.']")));
        //     return false;
        // }

        WebElement resultButton = getElement(new By.ByXPath(Locators.get("searchResultLinkXpath")));
        WebElement roResultMsg = 
        return getElement(new By.ByXPath(Locators.get("searchResultLinkXpath"))).isDisplayed() && !getElement(new By.ByXPath(Locators.get("noSearchResultText"))).isDisplayed();
        
    }

    // public void allResultsClick(){
    //     try {
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allResultsButtonXpath)));
    //         driver.findElement(By.xpath(allResultsButtonXpath)).click();
    //     } catch (Exception e) {
    //         System.out.println(e.toString());
    //     }
    // }


    //uses for static, all-time accessable by default elements
    private WebElement getElement(By byLocator){
        return driver.findElement(byLocator);
    }

    //uses for dynamic, accessable after some events elements
    private WebElement getElement(By byLocator, Wait wait){
         try {
            wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(byLocator), 
                ExpectedConditions.visibilityOfElementLocated(byLocator)
            ));
            return driver.findElement(byLocator);
         } catch (Exception e) {
            Assert.fail("element by locator " + byLocator + " is not finded");
            return null;
         }
    }

    public void allResultsClick(){
        getElement(new By.ByXPath(Locators.get("allResultsButtonXpath")), wait).click();
        System.err.println("click success");
    }

    public void searchSubmit(){
        getElement(new By.ByClassName(Locators.get("searchFieldName"))).submit();
    }

    public void searchClear(){
        getElement(new By.ByClassName(Locators.get("searchFieldName"))).clear();
    }

    //locations
    public boolean isLocationsVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.get("locationListXpath"))));
            return true;
        } catch (Exception e) {
            System.out.println("locations list not founded");
            return false;
        }
    }

    public boolean isLocationsInvisible(){
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Locators.get("locationListXpath"))));
            return true;
        } catch (Exception e) {
            System.out.println("locations list is visible");
            return false;
        }
    }

    public void locationsClick(){
        getElement(new By.ByXPath(Locators.get("locationListXpath"))).click();
    }

    //phones
    public boolean isPhonesVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.get("phoneListXpath"))));
            return true;
        } catch (Exception e) {
            System.out.println("locations list not founded");
            return false;
        }
    }

    public boolean isPhonesInvisible(){
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Locators.get("phoneListXpath"))));
            return true;
        } catch (Exception e) {
            System.out.println("locations list not founded");
            return false;
        }
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

    interface Waitable{
        void execute(String xPath);
    }
    

}

