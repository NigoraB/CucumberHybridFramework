@Login
Feature: Login functionality

@Regression
Scenario Outline: Login with valid credentials
Given  User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username								|password	|
|qa.test@gmail.com	|validPassword@123|
|qa.test3@gmail.com	|validPassword@456|

@Smoke @Skip
Scenario: Login with invalid credentials
Given  User navigates to login page
When User enters invalid email address into email field
And User enters invalid password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

@Smoke
Scenario: Login with valid email and invalid password
Given  User navigates to login page
When User enters valid email address "qa.test@gmail.com" into email field
And User enters invalid password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

@Smoke
Scenario: Login with invalid email and valid password
Given  User navigates to login page
When User enters invalid email address into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

@Smoke 
Scenario: Login without providing any credentails
Given  User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch 