Feature: ProductCategoryPageWomen

Scenario: Verify total number of Women Dress Products based on color

Given navigate to application
And User click on women navigation menu
And click on orange color filter
Then verify total number of product displayed as "3" 