package com.cucumber.framework.stepdefinition.Registration;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.cucumber.framework.pageobject.LoginPage;
import com.cucumber.framework.pageobject.RegistrationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.log4j.Logger;

public class Registration {
	
	private Logger log = LoggerHelper.getLogger(Registration.class);
	RegistrationPage registrationPage;
	LoginPage loginPage;
	
	@And("^enter registration emailID$")
	public void enter_registration_emailID() throws Throwable {
		loginPage = new LoginPage(TestBase.driver);
		loginPage.enterRegistrationEmail();
	}

	@And("^click on create an account button$")
	public void click_on_create_an_account() throws Throwable {
		registrationPage = loginPage.clickOnCreateAnAccount();
	}

	@Then("^registration form open$")
	public void registration_form_open() throws Throwable {
		new GenericHelper().isDisplayed(registrationPage.mrRadioButton);
	    
	}
	
	@And("^enter first name \"([^\"]*)\"$")
	public void enter_first_Name(String arg1) throws Throwable {
		registrationPage.setFirstName(arg1);
	}
	
	@And("^enter last name \"([^\"]*)\"$")
	public void enter_last_Name(String arg1) throws Throwable {
		registrationPage.setLastname(arg1);
	}
	
	@And("^enter password \"([^\"]*)\"$")
	public void enter_password(String arg1) throws Throwable {
		registrationPage.setPassword(arg1);
	}
	
	@And("^select mr radio button$")
	public void select_mr_radio_button() throws Throwable {
		registrationPage.setMrRadioButton();   
	}

	@And("^select day \"([^\"]*)\"$")
	public void select_day(String arg1) throws Throwable {
		registrationPage.setDay(arg1);
	}

	@And("^select month \"([^\"]*)\"$")
	public void select_month(String arg1) throws Throwable {
		registrationPage.setMonth(arg1);
	}

	@And("^select year \"([^\"]*)\"$")
	public void select_year(String arg1) throws Throwable {
		registrationPage.setYear(arg1);
	}

	@And("^enter your address first name \"([^\"]*)\"$")
	public void enter_your_address_first_Name(String arg1) throws Throwable {
		registrationPage.setYourAddressFirstName(arg1);
	}

	@And("^enter your address last name \"([^\"]*)\"$")
	public void enter_your_address_last_Name(String arg1) throws Throwable {
		registrationPage.setYourAddressLastName(arg1);
	}

	@And("^enter your company name \"([^\"]*)\"$")
	public void enter_your_company_Name(String arg1) throws Throwable {
		registrationPage.setYourAddressCompany(arg1);
	}

	@And("^enter Address \"([^\"]*)\"$")
	public void enter_Address(String arg1) throws Throwable {
		registrationPage.setAddress(arg1);
	}

	@And("^enter Address city \"([^\"]*)\"$")
	public void enter_Address_city(String arg1) throws Throwable {
		registrationPage.setYourAddressCity(arg1);
	}

	@And("^select state \"([^\"]*)\"$")
	public void select_state(String arg1) throws Throwable {
		registrationPage.setYourAddressState(arg1);
	}

	@And("^Select zipcode \"([^\"]*)\"$")
	public void select_zipcode(String arg1) throws Throwable {
		registrationPage.setYourAddressPostCode(arg1);
	}

	@And("^Select mobile phone number \"([^\"]*)\"$")
	public void select_mobile_phone_nymber(String arg1) throws Throwable {
		registrationPage.setMobilePhone(arg1);
	}

	@And("^Assign an address alias \"([^\"]*)\"$")
	public void assign_an_address_alias(String arg1) throws Throwable {
		registrationPage.setAddressAlias(arg1);
	}
	
	@And("^click on registration button$")
	public void click_on_registration_button() throws Throwable {
		registrationPage.clickRegistration();
	}

	@Then("^verify registration success message$")
	public void verify_Registration_success_message() throws Throwable {
		Thread.sleep(8000);
	}

}
