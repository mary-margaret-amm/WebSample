package com.example.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.BaseClassA;

public class HomePageLocator extends BaseClassA {

    public static WebElement getSubscriptionEmail() {
        return driver.findElement(
                By.xpath("//input[@type='email'][contains(@id,'susbscribe_email')]"));
    }

    public static WebElement getSubscriptionArrowBtn() {
        return driver.findElement(
                By.xpath("//button[@type='submit'][@id='subscribe']"));
    }

    public static WebElement getSuccessMessagElement() {
        return driver.findElement(
                By.xpath(
                        "//div[contains(@class,'alert-success alert')][text()='You have been successfully subscribed!']"));
    }
}