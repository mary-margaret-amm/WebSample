package com.example.Execution;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.BaseClassA;
import com.example.Locators.HomePageLocator;

public class HomePageExe extends HomePageLocator {

    public static void enterSubscriptionEmail(String data) {
        BaseClassA.sendKeys(HomePageLocator.getSubscriptionEmail(), data);
    }

    public static void subscriptionArrow_Click() {
        BaseClassA.click(HomePageLocator.getSubscriptionArrowBtn());
    }

    public static String verifySuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocator.getSuccessMessagElement())).click();
        BaseClassA.click(HomePageLocator.getSuccessMessagElement());
        String successMessage = HomePageLocator.getSuccessMessagElement().getText();
        System.out.println("Success message: " + successMessage);
        return successMessage;

    }

}
