package com.cucumber.framework.stepdefinition.HomePageCarDekho;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.configreader.PropertyFileReader;
import com.cucumber.framework.pageobject.HomePageCarDekho;
import com.cucumber.framework.pageobject.LoginPage;
import com.cucumber.framework.stepdefinition.ProductCategory.TestWomenTopsProductCategory;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.testng.TestNGCucumberRunner;

public class CDHomePageNewCarMenuSD {
	private final Logger log= LoggerHelper.getLogger(TestWomenTopsProductCategory.class);
	HomePageCarDekho cdHomePgObject;
	TestBase testbaseObj= new TestBase();
	public WebDriver driver;
	

@Then("^verify New Cars drop down on home page$")
public void user_verifies_home_page_is_displayed() throws Throwable {
	driver=TestBase.driver;
	System.out.println(driver.hashCode());
	cdHomePgObject= new HomePageCarDekho(driver);
	cdHomePgObject.verifyNewCarDropdown(cdHomePgObject.browserID);
   
}

}
