Feature: login

@sanity
Scenario: Succsseful Login with valid credentials
Given User Launch Chrome browser
When user opens URL "http://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login 
Then page Titile should be "Dashboard / nopCommerce administration"
When User click on log out link
Then page title should be "Your store. Login"
And close browser 

@regression
Scenario Outline: Login Data driven
Given User Launch Chrome browser
When user opens URL "http://admin-demo.nopcommerce.com/login"
And user enters Email as "<email>" and password as "<password>"
And Click on Login 
Then page Titile should be "Dashboard / nopCommerce administration"
When User click on log out link
Then page title should be "Your store. Login"
And close browser
Examples:
|email|password|
|admin@yourstore.com |admin|
|admin@yourstore.com|admin123|