
@sanity
Feature:Remove Products from cart
Scenario: Validating if the products are removed from cart
Given launch the url "https://www.automationexercise.com/"
When verify that home page is visible successfully
And Add products to cart
And Click Cart button
And Verify that cart page is displayed
And Click X button corresponding to particular product
Then Verify that product is removed from the cart

