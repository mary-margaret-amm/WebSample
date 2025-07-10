package com.example.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.Pom.BaseClassA;

public class RemoveProductLocator extends BaseClassA {

    public static WebElement getWinterTop() {
        return driver.findElement(
                By.xpath("(//a[@data-product-id='5'][contains(@class,'btn btn-default add-to-cart')])[1]"));
    }

}
