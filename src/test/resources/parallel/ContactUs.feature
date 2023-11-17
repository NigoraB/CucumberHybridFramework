Feature: Contact Us Feature

Scenario Outline: Contact us scenario with different set of data
Given user navigates to contact us page
When user fills the form from the given sheetname "<SheetName>" and <RowNumber>
And user clicks on submit button
Then It shows an error message

Examples: 
|SheetName|RowNumber|
|contactus|0|
|contactus|1|
|contactus|2|