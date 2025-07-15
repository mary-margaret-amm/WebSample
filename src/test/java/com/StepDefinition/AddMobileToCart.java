package com.StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddMobileToCart {

    public static WebDriver driver;

    @Given("Launch fURL {string}")
    public void launch_f_url(String fURL) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(fURL);
    }

    @When("I search for the {string}")
    public void i_search_for_the(String val) throws AWTException, InterruptedException {
        driver.findElement(By.xpath("//input[@name='q'][@type='text']")).sendKeys(val);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }

    @When("I apply filter {string}")
    public void i_apply_filter(String string) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + string + "']"))).click();
        Thread.sleep(2000);
        System.out.println("passed");

    }

    @When("I sort results by {string}")
    public void i_sort_results_by(String string) {

    }

    @Then("the cart page should list the mobile {string}")
    public void the_cart_page_should_list_the_mobile(String string) {

    }

}
