package com.cucumber.framework.runner.Registration;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features={"classpath:featurefile/registration/Registration.feature"} ,glue={
		   "classpath:com.cucumber.framework.stepdefinition",
		   "classpath:com.cucumber.framework.Helper"},
		   plugin = {"pretty", "html:target/cucumber-html-report"},
		   dryRun=false,
		   monochrome = false
)

public class RegistrationRunner extends AbstractTestNGCucumberTests{

}
