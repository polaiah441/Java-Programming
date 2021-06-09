Feature: Tagging verification

@SmokeTest @RegressionTest
Scenario: Login
Given user login success

@SmokeTest @End2End
Scenario: Logout
Given user logout

@SmokeTest @RegressionTest
Scenario: login fail case
Given user login failed

@SmokeTest
Scenario: logout fail
Given Logout failed for the given user

@End2End
Scenario: Login page title
Given login page title verify

@End2End
Scenario: search customer page
Given customer search page

@RegressionTest
Scenario: user reg 
Given user get registered


@RegressionTest
Scenario: create a new customer
Given create a new customer

@SmokeTest @RegressionTest
Scenario: File upload
Given File upload case
