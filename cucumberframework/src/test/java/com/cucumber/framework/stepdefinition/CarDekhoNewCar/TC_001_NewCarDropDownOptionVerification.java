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

public class TC_001_NewCarDropDownOptionVerification {
	
	private final Logger log= LoggerHelper.getLogger(TestWomenTopsProductCategory.class);
	HomePageCarDekho cdHomePgObject;
	TestBase testbaseObj= new TestBase();
	List<String> newCarDropDownValues= Arrays.asList("Search New Cars","Latest Cars","Popular Cars","Upcoming Cars"
			,"Offers and Discount","Dealers/Service Centers","On Road Price","Win iPhone");
	public WebDriver driver;
	
	
	@Then("^verify New Menu is displayed on the home page$")
	public void verify_New_Menu_is_displayed_on_the_home_page() throws Throwable {
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		cdHomePgObject= new HomePageCarDekho(driver);
		cdHomePgObject.verifyNewCarDropdown(cdHomePgObject.browserID);
	    
	}

	@And("^hover over New drop down$")
	public void hover_over_New_drop_down() throws Throwable {
		cdHomePgObject.hoverOverNewCarMenu(cdHomePgObject.browserID);
	
	}

	
	
	@Then("^verify correct drop down options are displayed$")
	public void verify_correct_drop_down_options_are_displayed() throws Throwable {
	    
		try
		{
			cdHomePgObject.verifyNewCarMenuOptions(newCarDropDownValues);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
