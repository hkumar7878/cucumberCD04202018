package com.cucumber.framework.stepdefinition.CarDekhoNewCar;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.HomePageCarDekho;
import com.cucumber.framework.stepdefinition.ProductCategory.TestWomenTopsProductCategory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class TC_002_NewCarByBudgetFilterDefaultSelections {
	
	private final Logger log= LoggerHelper.getLogger(TestWomenTopsProductCategory.class);
	HomePageCarDekho cdHomePgObject;
	TestBase testbaseObj= new TestBase();
	
	public WebDriver driver;
	
	@Then("^verify New Car tab is selected by default$")
	public void verify_New_Car_tab_is_selected_by_default() throws Throwable {
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		cdHomePgObject= new HomePageCarDekho(driver);
		System.out.println("Inside step def and browser Name is " + TestBase.browserID);
		cdHomePgObject.verifyNewCarTabSelection(TestBase.browserID);
		
	}
	
	
	
	@Then("^Verify By Budget radial button is selected by default$")
	public void verify_By_Budget_radial_button_is_selected_by_default() throws Throwable {
		cdHomePgObject.verifyByCarRadialBtnSelection(TestBase.browserID);
	   
	}

	@Then("^verify default value of budget drop down$")
	public void verify_default_value_of_budget_drop_down() throws Throwable {
		cdHomePgObject.verifyDefaultBudgetDropDownValue(TestBase.browserID, "-Select Budget-");
	  
	}

	@Then("^verify default value of vehicle type drop down$")
	public void verify_default_value_of_vehicle_type_drop_down() throws Throwable {
	 
		cdHomePgObject.verifyDefaultBudgetDropDownValue(TestBase.browserID, "All Vehicle Types");
	}


}
