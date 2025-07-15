package com.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class testString {

    @Given("enter the string value")
    public void enter_the_string_value() {
        System.out.println("MADAM");
    }

    @Then("verify if the string is a palindrome")
    public void verify_if_the_string_is_a_palindrome() {
        String s = "MADAM";
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            rev = rev + ch;

        }
        if (s.equals(rev)) {
            System.out.println("Palindrome string");

        } else {
            System.out.println("Not a palindrome string");
        }

    }

}
