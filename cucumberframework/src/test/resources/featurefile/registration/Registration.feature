Feature: Registration

  Scenario Outline: Register User
    Given navigate to application
    When user click on sign in link
    And enter registration emailID
    And click on create an account button
    Then registration form open
    And enter first name "<firstname>"
    And enter last name "<lastname>"
    And enter password "<password>"
    And select mr radio button
    And select day "<day>"
    And select month "<month>"
    And select year "<year>"
    And enter your address first name "<addressFirstName>"
    And enter your address last name "<addressLastName>"
    And enter your company name "<addressCompanyName>"
    And enter Address "<address>"
    And enter Address city "<City>"
    And select state "<state>"
    And Select zipcode "<zipcode>"
    And Select mobile phone number "<mobilePhoneNumber>"
    And Assign an address alias "<addressAlias>"
    And click on registration button
    Then verify registration success message

    Examples: 
      | firstname    | lastname    | password  | day | month    | year | addressFirstName    | addressLastName    | addressCompanyName    | address    | City    | state  | zipcode | mobilePhoneNumber | addressAlias    |
      | firstnameOne | lastnameOne | password1 |   3 | February | 2013 | addressFirstNameOne | addressLastNameOne | AddresscompanyNameOne | addressOne | Patiala | Alaska |  147001 |        9999982828 | addressAliasOne |

      
      # control + shift f to align the contents in feature file