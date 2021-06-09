Feature: Login

Scenario: successful login with valid credentials
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and password as "admin"
	And click on login
	Then page title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then page title should be "Your store. Login"
	And close browser
	And close browser1
	
Scenario Outline: Login data driven
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and password as "<password>"
	And click on login
	Then page title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then page title should be "Your store. Login"
	And close browser
	
	Examples:
		|	email | password |
		
	 	|	admin@yourstore.com	|	admin	|
	 	|	admin1@yourstore.com	|	admin1	|