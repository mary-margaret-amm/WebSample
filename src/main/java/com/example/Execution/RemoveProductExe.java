package com.example.Execution;

import com.example.BaseClassA;
import com.example.Locators.RemoveProductLocator;

public class RemoveProductExe extends RemoveProductLocator {

    public static void winterTopClick() {
        BaseClassA.click(RemoveProductLocator.getWinterTop());
    }

    public static void viewProductClick() {
        BaseClassA.click(RemoveProductLocator.getViewProduct());
    }

    public static void addToCartClick() {
        BaseClassA.click(RemoveProductLocator.getAddToCartButton());
    }

    public static void viewCartClick() {
        BaseClassA.click(RemoveProductLocator.getCartButton());
    }

    public static void removeProductClick() {
        BaseClassA.click(RemoveProductLocator.getRemoveButton());
    }

    public static void verifyProductRemoved() {
        BaseClassA.click(RemoveProductLocator.getCartIsEmptyElement());
        System.out.println(RemoveProductLocator.getCartIsEmptyElement().getText());
        System.out.println("Verified");

    }

}
