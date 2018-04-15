package com.cucumber.framework.stepdefinition.ProductCategory;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.pageobject.HomePage;
import com.cucumber.framework.pageobject.WomenMainPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class WomenDressesProductCategory {
	
private final Logger log= LoggerHelper.getLogger(WomenDressesProductCategory.class);
HomePage homepage;
WomenMainPage womenproductcatpage;

@Given("^User click on women navigation menu$")
public void user_click_on_women_navigation_menu() throws Throwable {
  homepage = new HomePage(TestBase.driver);
  log.info("Clicking on Women menu");
  womenproductcatpage = homepage.clickOnMenu(homepage.womenMenu);
    
}

@And("^click on orange color filter$")
public void click_on_orange_color_filter() throws Throwable {
   womenproductcatpage.selectColor(womenproductcatpage.Orange);
   log.info("We are selecting " +womenproductcatpage.Orange);
    
}

@Then("^verify total number of women product displayed as \"([^\"]*)\"$")
public void verify_total_number_of_women_product_displayed_as(String arg1) throws Throwable {
   int total= womenproductcatpage.getTotalProducts();
   if(total==Integer.parseInt(arg1))
	   Assert.assertTrue(true, "given product count is matching");
   else
	   Assert.assertFalse(false,"given product count is not matching");
   
}

@Then("^verify total number of product displayed as \"([^\"]*)\"$")
public void verify_total_number_of_product_displayed_as(String arg1) throws Throwable {
   int total= womenproductcatpage.getTotalProducts();
   if(total==Integer.parseInt(arg1))
	   Assert.assertTrue(true, "given product count is matching");
   else
   {
	   log.info("actual product count is " +total);
	   Assert.assertFalse(false,"given product count is not matching");
   }
   
}

}
