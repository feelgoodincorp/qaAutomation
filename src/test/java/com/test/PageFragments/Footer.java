package com.test.PageFragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Footer {
    WebDriver driver;

    final String elem = "";
    
    public Footer(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
