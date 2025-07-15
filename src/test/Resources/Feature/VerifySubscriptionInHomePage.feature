Feature: Mary_Web_Verify Subscription in Home Page
    @regs_1
    Scenario: Verify Subscription in Home Page

        Given launching the url "https://www.automationexercise.com/"
        When verify that the home page is visible successfully
        And Scroll down to footer
        And Verify the text SUBSCRIPTION
        And Enter the email address in input and click arrow button "marymargaret.ap@gmail.com"
        And Verify if the success message is visible "You have been successfully subscribed!"



