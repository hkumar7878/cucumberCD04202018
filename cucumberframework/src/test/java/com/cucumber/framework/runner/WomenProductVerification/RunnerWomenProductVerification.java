package com.cucumber.framework.runner.WomenProductVerification;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;

import java.io.File;

@CucumberOptions(features={"classpath:featurefile/productCategory/TestWomenTopAndDressesFunctionality.feature"}
,glue={"classpath:com.cucumber.framework.stepdefinition",
	   "classpath:com.cucumber.framework.Helper"},
		plugin = {"html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json"},
	 //  plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
		dryRun=false,
		monochrome = false
)

public class RunnerWomenProductVerification {
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before running the suite");
	}
	
	/*@BeforeClass
    public static void setup() {
		System.out.println("Before running the beforeClass");
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//        extentProperties.setExtentXServerUrl("http://localhost:1337");
//        extentProperties.setProjectName("MyProject");
        extentProperties.setReportPath("output/myreport.html");
}*/
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After running the suite");
	}
	/*@AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Win");
        Reporter.setTestRunnerOutput("Sample test runner output message");
        System.out.println("After running the AfterClass");
    }*/
	@Test()
	public void runCukes()
	{
		new TestNGCucumberRunner(getClass()).runCukes();
	}

}

