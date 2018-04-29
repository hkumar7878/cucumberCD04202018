package com.cucumber.framework.stepdefinition.HomePageCarDekho;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.pageobject.PageHomeCarDekho;
import com.cucumber.framework.pageobject.LoginPage;
import com.cucumber.framework.stepdefinition.ProductCategory.TestWomenTopsProductCategory;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.testng.TestNGCucumberRunner;




public class CDHomePageSD {
	private final Logger log= LoggerHelper.getLogger(TestWomenTopsProductCategory.class);
	PageHomeCarDekho cdHomePgObject;
	public WebDriver driver;
	

@Given("^navigate to web site$")
public void navigate_to_web_site() throws Throwable {
	TestBase.driver.get(ObjectRepo.reader.getWebSite());
  
}

@Then("^user verifies home page is displayed$")
public void user_verifies_home_page_is_displayed() throws Throwable {
	driver=TestBase.driver;
	System.out.println(driver.hashCode());
	cdHomePgObject= new PageHomeCarDekho(driver);
	cdHomePgObject.verifyHomePageDisplay(cdHomePgObject.browserID);
   
}

}
