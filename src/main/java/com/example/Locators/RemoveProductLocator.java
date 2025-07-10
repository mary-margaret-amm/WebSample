package com.example.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.BaseClassA;

public class RemoveProductLocator extends BaseClassA {

    public static WebElement getWinterTop() {
        return driver.findElement(
                By.xpath("(//a[@data-product-id='5'][contains(@class,'btn btn-default add-to-cart')])[1]"));
    }

    public static WebElement getViewProduct() {
        return driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-justified']/child::li/child::a[1]"));
    }

    public static WebElement getAddToCartButton() {
        return driver.findElement(By.xpath("//button[@type='button'][contains(@class,'btn btn-default cart')]"));
    }

    public static WebElement getCartButton() {
        // return driver.findElement(By.xpath("//p[@class='text-center']/child::a"));
        return driver.findElement(By.partialLinkText("View Cart"));

    }

    public static WebElement getRemoveButton() {
        return driver.findElement(By.xpath("//a[@class='cart_quantity_delete']"));
    }

    public static WebElement getCartIsEmptyElement() {
        return driver.findElement(By.xpath("//p[@class='text-center'][@style='font-size: 18px;']/child::b"));
    }

}
