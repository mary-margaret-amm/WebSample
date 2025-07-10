package com.example.Execution;

import com.example.BaseClassA;
import com.example.Locators.RemoveProductLocator;

public class RemoveProductExe extends RemoveProductLocator {

    public static void winterTopClick() {
        BaseClassA.click(RemoveProductLocator.getWinterTop());
    }

}
