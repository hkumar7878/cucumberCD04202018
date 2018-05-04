Feature: To verify scenarios related with New Car functionality

  @TC_001
  Scenario: Verify the options in New Drop down menu
    Given navigate to web site
    Then user verifies home page is displayed
    And verify New Menu is displayed on the home page
    And hover over New drop down
    Then verify correct drop down options are displayed

  @TC_002
  Scenario: Verify Budget and All vehicle type drop down values for New Car for By Budget option
    Given navigate to web site
    Then user verifies home page is displayed
    And verify New Car tab is selected by default
    And Verify By Budget radial button is selected by default
    And verify default value of budget drop down
    And verify default value of vehicle type drop down
    And verfiy the values for Budget drop down values
    And verfiy the values for Vehicle drop down values

  @TC_003
  Scenario Outline: Verify search results on the basis of budget value for New Car for By Budget option
    Given navigate to web site
    Then user verifies home page is displayed
    And verify New Car tab is selected by default
    And Verify By Budget radial button is selected by default
    And verify default value of budget drop down
    And verify default value of vehicle type drop down
    And verfiy the values for Budget drop down values
    And verfiy the values for Vehicle drop down values
    And select "<budget>" value from Select Budget drop down
    And select "<vehicle type>" from All Vehicle Types drop down
    And click on search button
    And verify that search result page is displayed by displaying correct expected budget "<ExpBudget>" and vehicle type "<ExpVehicleType>"

    Examples: 
      | budget          | vehicle type | ExpBudget              | ExpVehicleType |  
      | 1 Lakh - 5 Lakh | Hatchback    | Rs 1 Lakh to Rs 5 Lakh | Hatchback      |  
      | 1 Lakh - 5 Lakh | Sedans       | Rs 1 Lakh to Rs 5 Lakh | Sedans         | 

  Scenario: Verify search results on the basis of brand value for New Car for vehicle type
    Given navigate to web site
    Then verify New Cars drop down on home page

  Scenario: Verify Budget and Select City drop down values for Used Car for By Budget option
    Given navigate to web site
    Then verify New Cars drop down on home page
