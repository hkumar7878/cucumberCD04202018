package com.cucumber.framework.runner.Login;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features={"classpath:featurefile/login/login.feature"} ,glue={
						   "classpath:com.cucumber.framework.stepdefinition",
						   "classpath:com.cucumber.framework.Helper"},
						   plugin = {"pretty", "html:target/cucumber-html-report"},
						   dryRun=false,
						   monochrome = false
				 )
public class LoginRunner extends AbstractTestNGCucumberTests{ 

}
