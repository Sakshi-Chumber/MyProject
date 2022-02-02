Feature: Testing Sign up and Login Functionality
Scenario Outline: Testing Sign up Functionality
Given User must be on Homepage url "https://demoblaze.com/"
When User click on Sign up
And Enter valid <username> and <password>
And Clicks on Sign up button
Then Dialog box should be displayed "Sign up succesfull"

Examples:
|username|password|
|GANDALF|BILBO|


