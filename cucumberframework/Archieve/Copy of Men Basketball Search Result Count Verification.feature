
#Author: Hitesh

Feature: Men and Women product verification feature
	Keyword Summary: This feature will verify scenarios related with Men and Womens Product's verification
	
	@RegressionTest1
	
   Scenario: Validate Women's Tshirt page verification
   #When Open a browser and open Adidas online store site
   #Then Verify Adidas online store Home Page
    And Hover over Women Menu
    Then Verify Women Menu opens
    Then Click on T Shirts link
    Then verify Women T Shirt page appears
    #Then Validate Search Count of Women Tshirt
   @RegressionTest2 
 Scenario: Validate Basketball page verification and search result count verification
    #When Open a browser and open Adidas online store site
    #Then Verify Adidas online store Home Page
    And Hover over Men Menu
    Then Verify Men Menu opens
    Then Click on Basketball link
    Then verify Men Basketball page appears
    #Then Validate Search Count of Men basketball
    
  
 
    
    
    
    
    
    
    