package com.cucumber.framework.stepdefinition.CarDekhoNewCar;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.PageHomeCarDekho;
import com.cucumber.framework.pageobject.PageSearchResults;
import com.cucumber.framework.stepdefinition.ProductCategory.TestWomenTopsProductCategory;

import cucumber.api.java.en.Then;

public class TC_003_NewCar_BudgetWithVehicleTypeDataTable {

	private final Logger log = LoggerHelper.getLogger(TestWomenTopsProductCategory.class);
	PageHomeCarDekho cdHomePgObject;
	PageSearchResults searchPgObject;
	TestBase testbaseObj = new TestBase();

	public WebDriver driver;
	List<String> searchOptions= Arrays.asList("HatchBack","Rs 1 Lakh to Rs 5 Lakh");

	@Then("^select \"([^\"]*)\" value from Select Budget drop down$")
	public void select_value_from_Select_Budget_drop_down(String vehicleBudget) throws Throwable {
		driver = TestBase.driver;
		System.out.println(driver.hashCode());
		cdHomePgObject = new PageHomeCarDekho(driver);
		System.out.println("Inside step def and browser Name is " + TestBase.browserID);
		cdHomePgObject.selectOptionForNewCarForSearch(vehicleBudget,TestBase.browserID, "budgetOption");
	}

	@Then("^select \"([^\"]*)\" from All Vehicle Types drop down$")
	public void select_from_All_Vehicle_Types_drop_down(String vehicleType) throws Throwable {
		cdHomePgObject.selectOptionForNewCarForSearch(vehicleType,TestBase.browserID, "vehicleType");
	}

	@Then("^click on search button$")
	public void click_on_search_button() throws Throwable {
		searchPgObject = cdHomePgObject.clickSearchBtn(TestBase.browserID);
	}
	
	@Then("^verify that search result page is displayed by displaying correct expected budget \"([^\"]*)\" and vehicle type \"([^\"]*)\"$")
	public void verify_that_search_result_page_is_displayed_by_displaying_correct_expected_budget_and_vehicle_type(String expBudgetVal, String expVehicleName) throws Throwable {
		searchPgObject.verifyResults(TestBase.browserID,expBudgetVal,expVehicleName);
	}

}
