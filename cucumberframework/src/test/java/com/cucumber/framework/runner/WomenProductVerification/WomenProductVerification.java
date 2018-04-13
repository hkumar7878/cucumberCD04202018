package com.cucumber.framework.runner.WomenProductVerification;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features={"classpath:featurefile/productCategory/TestTotalNumberOfWomenDressProduct.feature"}
,glue={"classpath:com.cucumber.framework.stepdefinition",
	   "classpath:com.cucumber.framework.Helper"},
		plugin = {"pretty", "html:target/cucumber-html-report"},
		dryRun=false,
		monochrome = false
)

public class WomenProductVerification {
	
	@BeforeSuite
	
	public void beforeSuite()
	{
		System.out.println("Before running the suite");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After running the suite");
	}
	
	@Test()
	public void runCukes()
	{
		new TestNGCucumberRunner(getClass()).runCukes();
	}

}

