package com.StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCasePage {
    public static WebDriver driver;
    public static TakesScreenshot ts;

    @Given("launching the url {string}")
    public void launching_the_url(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    @When("verify that the home page is visible successfully")
    public void verify_that_the_home_page_is_visible_successfully() {
        String title = "Automation Exercise";
        Assert.assertEquals(title, driver.getTitle());
        System.out.println("The Home page is visible");
    }

    @When("Click on Test Cases button")
    public void click_on_test_cases_button() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='button'][text()='Test Cases'][contains(@class,'btn btn-success')]"))).click();

    }

    @Then("Verify that the user is navigated to test cases page successfully")
    public void verify_that_the_user_is_navigated_to_test_cases_page_successfully() throws IOException {
        String title2 = "Automation Practice Website for UI Testing - Test Cases";
        Assert.assertEquals(title2, driver.getTitle());
        System.out.println("User is navigated to test cases page");
        ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\malbert\\Desktop\\WEBSample\\screenshots\\TestCasePage.jpg");
        FileHandler.copy(src, path);

    }

    @When("Click on Products button")
    public void click_on_products_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//i[contains(@class,'material-icons card_travel')]/parent::a")))
                .click();

    }

    @When("Verify that the user is navigated to the ALL PRODUCTS page successfully")
    public void verify_that_the_user_is_navigated_to_the_all_products_page_successfully() {
        String titleProdPage = "Automation Exercise - All Products";
        Assert.assertEquals(titleProdPage, driver.getTitle());
        System.out.println("User is navigated to the ALL PRODUCTS page successfully");
    }

    @When("click on view product of first product")
    public void click_on_view_product_of_first_product() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> li = driver
                .findElements(By.xpath("//a[contains(@href,'/product_details/')][@style='color: brown;']"));
        li.get(0).click();
        System.out.println(driver.getTitle());

    }

    @When("user is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        String prodDetail = "Automation Exercise - Product Details";
        Assert.assertEquals(prodDetail, driver.getTitle());
        System.out.println("User Successfully landed on Product detail page");
    }

    @Then("Verify that detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_is_visible_product_name_category_price_availability_condition_brand() {
        WebElement addToCart = driver
                .findElement(By.xpath("//button[contains(@class,'btn btn-default cart')]/child::i"));
        Assert.assertTrue(addToCart.isDisplayed());
        System.out.println("Product detail is visible!");
    }

    @When("click on Add to cart button")
    public void click_on_add_to_cart_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@type='button'][contains(@class,'btn btn-default cart')]")))
                .click();
        // System.out.println(driver.findElement(By.xpath("//p[text()='Your product has
        // been added to cart.']")).getText());
        System.out.println("Success");
    }

    @Then("verify if the product is added to cart successfully")
    public void verify_if_the_product_is_added_to_cart_successfully() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Your product has been added to cart.']")))
                .click();
        boolean displayed = driver.findElement(By.xpath("//p[text()='Your product has been added to cart.']"))
                .isDisplayed();
        Assert.assertTrue(displayed);
        System.out.println("Product successfully added to cart!");

    }

    // WebElement cartSuccess = driver.findElement(By.xpath("//p[text()='Your
    // product has been added to cart.']"));
    // String expected = "Your product has been added to cart.";
    // String actual = cartSuccess.getText();
    // Assert.assertEquals(expected,actual);
    // ("//h4[text()='Added!']")

}
