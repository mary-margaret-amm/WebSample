Feature: Dhilip_Web_ContactUs functionality

Scenario: ContactUs Form without file upload
Given User is on the home page
Then Verify Contact Us is visible
When Click on Contact Us button
Then enter name in contact us form "abcd" 
Then enter email in contact us form "abcb@xyz.com"
Then enter subject in contact us form "Checking"
Then enter message in contact us form "New Message"
Then Click Submit button
When Click OK button
Then Verify success message is visible


 
