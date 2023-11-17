
Feature: My Account Page feature

Background:

Given User has already logged in to application
|username | password |
|qa.test@gmail.com	|validPassword@123|


Scenario: My Acconut Page Tittle
Given user is on My Account page
When user gets the title of the page
Then page title should be "My Account"

Scenario: My Account section count
Given user is on My Account page
Then user gets My account section
      |My Account| 
      |My Orders| 
      |My Affiliate Account|    
			|Newsletter|
Then count should be 4		
