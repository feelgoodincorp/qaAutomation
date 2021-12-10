package com.test.Tests;

import java.util.concurrent.TimeUnit;

import com.test.ConfProperties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class Autotest {
 
    static public WebDriver driver;
    
    @BeforeClass
    public static void setup() {
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
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
   }