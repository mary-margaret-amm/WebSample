
Feature: Validating Test Case Page and Product Detail page

    #   Background: launching url
    #      Given launching the url "https://www.automationexercise.com/"

    @reg_1
    Scenario: Verify Test Case Page
        Given launching the url "https://www.automationexercise.com/"
        When verify that the home page is visible successfully
        And Click on Test Cases button
        Then Verify that the user is navigated to test cases page successfully

    @reg_2
    Scenario: Verify Product Detail page
        Given launching the url "https://www.automationexercise.com/"
        When verify that the home page is visible successfully
        And Click on Products button
        And Verify that the user is navigated to the ALL PRODUCTS page successfully
        And click on view product of first product
        And user is landed to product detail page
        Then Verify that detail is visible: product name, category, price, availability, condition, brand

    @reg_3
    Scenario: Add Products in cart
        Given launching the url "https://www.automationexercise.com/"
        When verify that the home page is visible successfully
        And Click on Products button
        And click on view product of first product
        And click on Add to cart button
        Then verify if the product is added to cart successfully









