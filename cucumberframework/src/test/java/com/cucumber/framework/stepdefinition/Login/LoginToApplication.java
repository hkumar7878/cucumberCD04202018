package com.cucumber.framework.stepdefinition.Login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.pageobject.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToApplication {
	
	LoginPage loginPg;
	public WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	
	
	@Given("^navigate to application$")
	public void navigate_to_application() throws Throwable {
	   TestBase.driver.get(ObjectRepo.reader.getWebSite());
	}

	@When("^user click on sign in link$")
	public void user_click_on_sign_in_link() throws Throwable {
		driver=TestBase.driver;
		System.out.println(driver.hashCode());
		loginPg = new LoginPage(driver);
	    loginPg.clickOnSignLink();
	}

	@When("^enter email address as \"([^\"]*)\"$")
	public void enter_email_address_as(String emailAddress) throws Throwable {
	 loginPg.enterEmailAddress(emailAddress);
	   
	}

	@When("^enter password as \"([^\"]*)\"$")
	public void enter_password_as(String password) throws Throwable {
	    loginPg.enterPassword(password);
	}

	@When("^click on sign in button$")
	public void click_on_sign_in_button() throws Throwable {
	    
	}

	@Then("^login is successful$")
	public void login_is_successful() throws Throwable {
	    if(loginPg.verifySuccessLoginMsg())
	    	log.info("Login test is passed");
	    else
	    	Assert.assertTrue(false, this.getClass().getSimpleName() + " is fail");
	    
	}

}
