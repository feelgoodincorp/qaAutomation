package com.test.TestSuits;

import java.util.concurrent.TimeUnit;

import com.test.ConfProperties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class HeaderSuite {

    static public WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.get("chromedriver"));

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-sandbox");
        
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().window().setPosition(new Point(1800,0));
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
    
}
