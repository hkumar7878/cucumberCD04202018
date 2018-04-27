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
	
	List<String> newCarBudgetDropDownExpOptions=Arrays.asList("-Select Budget-","1-lakh-5-lakh","5-lakh-10-lakh","10-lakh-20-lakh",
			"20-lakh-50-lakh","50-lakh-1-crore","above-1-crore");
	
	List<String> newCarAllVehicleTypeDropDownExpOptions= Arrays.asList("All Vehicle Types","Hatchback","Sedans","MUV","SUV",
			"luxury","Hybrids","Minivans","Convertibles","Coupe","Diesel Engines","Wagons","Pickup Trucks");
	
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
		cdHomePgObject.verifyDefaultDropDownValue(TestBase.browserID,"Budget", "-Select Budget-");
	  
	}

	@Then("^verify default value of vehicle type drop down$")
	public void verify_default_value_of_vehicle_type_drop_down() throws Throwable {
	 
		cdHomePgObject.verifyDefaultDropDownValue(TestBase.browserID,"Vehicle", "All Vehicle Types");
	}
	

	@Then("^verfiy the values for Budget drop down values$")
	public void verfiy_the_values_for_Budget_drop_down_values() throws Throwable {
		cdHomePgObject.verifyNewCarBudgetDropDownOptions(newCarBudgetDropDownExpOptions, TestBase.browserID);
	}

	@Then("^verfiy the values for Vehicle drop down values$")
	public void verfiy_the_values_for_Vehicle_drop_down_values() throws Throwable {
		
		cdHomePgObject.verifyNewCarAllVehicleTypeDropDownOptions(newCarAllVehicleTypeDropDownExpOptions, TestBase.browserID);
	    
	}




}
