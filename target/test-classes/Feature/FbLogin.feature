@smoke_1
Feature: Login Page

#Background: Browser launch
#Given launch the url

@multiple 
Scenario Outline: Validation of Login Page
Given launching url
When user enters the userone "<username>"
And user enters the passone "<password>"
#And clicks the fblogin button
#Then user is directed to the fb home page

Examples:
|username|password|
|Mary|1234|
|Muthu|4567|
|Dhilip|5436|

