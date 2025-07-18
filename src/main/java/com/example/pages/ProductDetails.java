package com.example.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetails {
WebDriver driver;

public ProductDetails(WebDriver driver) {
        this.driver = driver;
}
public void openLoginPage(String url) {
    driver.get(url);
}
public void ProductOptionVisible(){
    WebElement ProductOptionElement= driver.findElement(By.xpath("//a[@href='/products']"));
    boolean productoptionisVisible=ProductOptionElement.isDisplayed();
    Assert.assertTrue("Product not visible", productoptionisVisible);
}
public void ProductOptionClick(){
driver.findElement(By.xpath("//a[@href='/products']")).click();
}
public void AllProductVisible(){
    WebElement AllProductElement= driver.findElement(By.xpath("//h2[@class='title text-center']"));
    boolean allproductIsVisible = AllProductElement.isDisplayed();
    Assert.assertTrue("All Product not visible", allproductIsVisible);
}
public void FirstViewProdcutClick(){
    driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
}
public void FirstProductDetails(){
    WebElement productname= driver.findElement(By.xpath("//h2[text()='Blue Top']"));
    Assert.assertTrue("Product name not displayed", productname.isDisplayed());

    WebElement productprice= driver.findElement(By.xpath("//span[text()='Rs. 500']"));
    Assert.assertTrue("Product price not displayed", productprice.isDisplayed());

    WebElement productavailavility= driver.findElement(By.xpath("//p[text()=\" In Stock\"]"));
    Assert.assertTrue("Product availability not displayed", productavailavility.isDisplayed());
}
public void enterProductInSearch(String product){
    driver.findElement(By.id("search_product")).sendKeys(product);
}
public void searchProductClick(){
    driver.findElement(By.id("submit_search")).click();
}
public void searchedProductVisible(){
    WebElement searchedProductElement= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
    boolean searchedProductIsVisible = searchedProductElement.isDisplayed();
    Assert.assertTrue("Searched Product not visible", searchedProductIsVisible);
}
public void verifyAllProductsMatchSearch(String searchedproductname) {
    List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
    for (WebElement product : products){
        String productname = product.getText();
       Assert.assertTrue(productname, productname.toLowerCase().contains(searchedproductname.toLowerCase())); 
    }
}
}