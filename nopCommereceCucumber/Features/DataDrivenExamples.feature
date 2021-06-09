Feature: data driven Testing

Scenario: Login to application without examples keyword
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and password as "admin"
	And click on login 
	Then user can view Dashboard
	And close browser
		
Scenario Outline: Login data driven with Examples keyword
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and password as "<password>"
	And click on login
	And close browser
	
	Examples:
		|	email | password |
		
	 	|	admin@yourstore.com	|	admin	|
	 	|	admin1@yourstore.com	|	admin1	|
	 	
Scenario: Login to Application with data table List Object
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters username and password
	| admin@yourstore.com | admin |
	And click on login
	And close browser
	
	Scenario: Login to Application with data table  Maps Object
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters credentials
	| username 						| password |
	| admin@yourstore.com | admin		|
	And click on login
	And close browser
