
Feature: Customers

Background: These are common steps for all scenarios
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and password as "admin"
	And click on login 
	Then user can view Dashboard
	
Scenario: Add new customers
	When user clicks on Customers Menu 
	And click on Customer Menu Item
	And click on Add new button
	Then user can view Add New customer page
	When user enters customer info
	And click on save button
	Then user can view confirmation page "The new customer has been added successfully."
	And close browser
	
Scenario: Search customers by email id
	When user clicks on Customers Menu 
	And click on Customer Menu Item
	And enter customer email id
	When click on search button
	Then User should found email in the search table 
	And close browser
	
Scenario: Search customers by name
	When user clicks on Customers Menu 
	And click on Customer Menu Item
	And enter customer first name
	And enter customer last name
	When click on search button
	Then User should found Name in the search table 
	And close browser
	

   