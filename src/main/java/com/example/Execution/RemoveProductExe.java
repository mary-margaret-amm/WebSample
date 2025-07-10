package com.example.Execution;

import com.example.Locators.RemoveProductLocator;
import com.example.Pom.BaseClassA;

public class RemoveProductExe extends RemoveProductLocator {

    public static void winterTopClick() {
        BaseClassA.click(RemoveProductLocator.getWinterTop());
    }

}
