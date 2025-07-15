package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClassA {
    public static WebDriver driver;

    public static void sendKeys(WebElement element, String data) {
        element.sendKeys(data);
    }

    public static void click(WebElement element) {
        element.click();
    }

}
