Feature: Dhilip_Web_Products and product detail page

Scenario: verify product details visible
Given Given User is on the home page
Then verify product option is visible
When click on product option
Then verify user is navigated to all products page
When Click on View Product of first product
Then verify product name, price and availability 

Scenario: verify product searched in search option  
Given Given User is on the home page
When click on product option
Then verify user is navigated to all products page
Then  Enter product name in search input "Tshirt"
Then verify searched product is visible
Then click searchoption button
Then verify searched product "Tshirt" are visible