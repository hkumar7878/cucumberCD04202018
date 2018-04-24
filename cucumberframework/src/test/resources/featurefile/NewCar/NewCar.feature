Feature: To verify scenarios related with New Car functionality


@TC_001
Scenario: Verify the options in New Drop down menu

Given navigate to web site
Then user verifies home page is displayed
And verify New Menu is displayed on the home page
And hover over New drop down
Then verify correct drop down options are displayed

Scenario: Verify Budget and All vehicle type drop down values for New Car for By Budget option 

Given navigate to web site
Then verify New Cars drop down on home page

Scenario: Verify Budget and Select City drop down values for Used Car for By Budget option 
Given navigate to web site
Then verify New Cars drop down on home page

Scenario: Verify search results on the basis of budget value for New Car for By Budget option 
Given navigate to web site
Then verify New Cars drop down on home page

Scenario: Verify search results on the basis of brand value for New Car for vehicle type
Given navigate to web site
Then verify New Cars drop down on home page