package com.cucumber.framework.runner.WomenProductVerification;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features={"classpath:featurefile/productCategory/TestTotalNumberOfWomenDressProductBasedOnColor.feature"}
,glue={"classpath:com.cucumber.framework.stepdefinition",
	   "classpath:com.cucumber.framework.Helper"},
		plugin = {"pretty", "html:target/cucumber-html-report"},
		dryRun=false,
		monochrome = false
)

public class RunnerWoProVerificationBasedOnProductColorTestNgDiffApp extends AbstractTestNGCucumberTests{

}


//committing on 04/13
