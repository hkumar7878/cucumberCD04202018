Feature: ProductCategoryPage

Scenario: Verify total number of Women Tops in Orange color 

Given navigate to application
And User click on women navigation menu
And User clicks on Tops link
Then Verify Tops page is displayed
Then verify total number of women product displayed as "7" 

