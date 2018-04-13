package com.cucumber.framework.runner.WomenProductVerification;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features={"classpath:featurefile/productCategory/TestTotalNumberOfWomenDressProduct.feature"}
,glue={"classpath:com.cucumber.framework.stepdefinition",
	   "classpath:com.cucumber.framework.Helper"},
		plugin = {"pretty", "html:target/cucumber-html-report"},
		dryRun=true,
		monochrome = false
)

public class WomenProductVerification extends AbstractTestNGCucumberTests{

}

