Feature: Customers

Background: Below are the common steps for each scenario
Given User Launch Chrome browser
When user opens URL "http://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login 
Then user can view Dashboard

@sanity
Scenario: Add a new Customer
When user click on customers Menu
And click on customers menu item
And click on add new button 
Then user can view add new customer page 
When user enter customer info 
And click on Save button 
Then user can view confirmation message "The new customer has been added successfully"
And close browser 

@regression
Scenario: Search Customer by Email 

When user click on customers Menu
And click on customers Menu item 
And Enter customer Email
When Click on search button 
Then User should found Email in search table 
And close browser 

@regression
Scenario: Search Customer by Name
When user click on customers Menu
And click on customers menu item
And Enter customer FirstName
And  Enter customer lastName
When Click on search button
Then User should found Name in the search table
And close browser