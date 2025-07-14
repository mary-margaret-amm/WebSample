Feature: Dhilip_Web_Products and product detail page

Scenario: verify product details visible
Given User is on the home page
Then verify product option is visible
When click on product option
Then verify user is navigated to all products page
When Click on View Product of first product
Then verify product name, price and availability

Scenario: Verify search product is working
Given User is on the home page
Then verify product option is visible
When click on product option
Then verify user is navigated to all products page
Then verify search product is visible
When search for a product "Tshirt"
Then Verify all the products related to search are visible
