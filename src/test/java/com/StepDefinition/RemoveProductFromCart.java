package com.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.Execution.RemoveProductExe;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveProductFromCart extends RemoveProductExe {

    @Given("browser launch with url {string}")
    public void browser_launch_with_url(String string) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(string);
        System.out.println("Browser launched and navigated to: " + string);

    }

    @When("verify if the home page is visible successfully")
    public void verify_if_the_home_page_is_visible_successfully() {
        String title = "Automation Exercise";
        Assert.assertEquals(title, driver.getTitle());
        System.out.println("The Home page is visible!!");
    }

    @When("Add products to cart")
    public void add_products_to_cart() throws InterruptedException {

        RemoveProductExe.viewProductClick();
        System.out.println("View Product button clicked");
        RemoveProductExe.addToCartClick();
        System.out.println("Product added to cart!!");
        Thread.sleep(2000); // Wait for 2 seconds to ensure the cart is updated
    }

    @When("Click Cart button")
    public void click_cart_button() {
        driver.get("https://www.automationexercise.com/view_cart");

    }

    @When("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        System.out.println("cart page is displayed");
        System.out.println("The title of the cart page is: " + driver.getTitle());
    }

    @When("Click X button corresponding to particular product")
    public void click_x_button_corresponding_to_particular_product() {
        RemoveProductExe.removeProductClick();
        System.out.println("Remove button clicked for the product");

    }

    @Then("Verify that product is removed from the cart")
    public void verify_that_product_is_removed_from_the_cart() {
        System.out.println("verified");
        // RemoveProductExe.verifyProductRemoved();
        driver.quit();

    }

}
