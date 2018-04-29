package com.cucumber.framework.stepdefinition.CarDekhoNewCar;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PageHomeCarDekho;
import com.cucumber.framework.pageobject.PageSearchResults;
import com.cucumber.framework.stepdefinition.ProductCategory.TestWomenTopsProductCategory;

import cucumber.api.java.en.Then;

public class TC_003_NewCar_BudgetWithVehicleType {
	
	private final Logger log= LoggerHelper.getLogger(TestWomenTopsProductCategory.class);
	PageHomeCarDekho cdHomePgObject;
	PageSearchResults searchPgObject;
	TestBase testbaseObj= new TestBase();
	
	public WebDriver driver;
	
	@Then("^select budget value from Select Budget drop down$")
	public void select_budget_value_from_Select_Budget_drop_down() throws Throwable {
	   
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		cdHomePgObject= new PageHomeCarDekho(driver);
		System.out.println("Inside step def and browser Name is " + TestBase.browserID);
	}

	@Then("^select vehicle type from All Vehicle Types drop down$")
	public void select_vehicle_type_from_All_Vehicle_Types_drop_down() throws Throwable {
		cdHomePgObject.selectOptionForNewCarForSearch("1 Lakh - 5 Lakh", TestBase.browserID,"budgetOption");
	}

	@Then("^click on search button$")
	public void click_on_search_button() throws Throwable {
		cdHomePgObject.selectOptionForNewCarForSearch("Hatchback", TestBase.browserID,"vehicleType");
	    
	}

	@Then("^verify that required next page is displayed$")
	public void verify_that_required_next_page_is_displayed() throws Throwable {
		//searchPgObject= new PageSearchResults(driver);
		
		searchPgObject= cdHomePgObject.clickSearchBtn(TestBase.browserID);
	}

}
