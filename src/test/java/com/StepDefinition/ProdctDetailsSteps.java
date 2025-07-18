package com.StepDefinition;

import com.example.BaseClass;
import com.example.pages.ProductDetails;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProdctDetailsSteps extends BaseClass {
ProductDetails productdetails;

public ProdctDetailsSteps() {
        productdetails = new ProductDetails(driver);
    }

@Then("verify product option is visible")
public void verify_product_option_is_visible() {
    productdetails.ProductOptionVisible();
}
@Then("click on product option")
public void click_on_product_option() {
    productdetails.ProductOptionClick();
}
@Then("verify user is navigated to all products page")
public void verify_user_is_navigated_to_all_products_page() {
    productdetails.AllProductVisible();
}
@When("Click on View Product of first product")
public void click_on_view_product_of_first_product() {
    productdetails.FirstViewProdcutClick();
}
@Then("verify product name, price and availability")
public void verify_product_name_price_and_availability() {
   productdetails.FirstProductDetails();
}
@Then("Enter product name in search input {string}")
public void enter_product_name_in_search_input(String product) {
    productdetails.enterProductInSearch(product);
}
@Then("click searchoption button")
public void click_searchoption_button() {
    productdetails.searchProductClick();
}
@Then("verify searched product is visible")
public void verify_searched_product_is_visible() {
   productdetails.searchedProductVisible();
}
@Then("verify searched product {string} are visible")
public void verify_searched_product_are_visible(String searchedproductname) {
   productdetails.verifyAllProductsMatchSearch(searchedproductname);
}

}
