package com.cucumber.framework.Helper.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.configreader.PropertyFileReader;
import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.configuration.browser.ChromeBrowser;
import com.cucumber.framework.configuration.browser.FireFoxBrowser;
import com.cucumber.framework.utility.ActionBeforeClass;
//import com.cucumber.framework.utility.ActionBeforeClass;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class TestBase {
	
	private final Logger log=LoggerHelper.getLogger(TestBase.class);
	public static WebDriver driver;
	public static Properties prop=null;
	ActionBeforeClass actionBeforeClass;
	public static String browserID=null;
	String XMLtestCaseName=null;
	String app_URL=null;
	
	public static ExtentReports report;
    public static ExtentReports report1;
    public static ExtentTest FF_logger;
    public static ExtentTest CH_logger;
    public static String scenarioName;
    
    @Before
	public void before(Scenario scenario) throws Exception
	{
		actionBeforeClass = new ActionBeforeClass();
    	scenarioName=scenario.getName();
		System.out.println("Before TESTNG before method");
		System.out.println("Starting of Before method");
		ObjectRepo.reader=new PropertyFileReader();
		String bName=ObjectRepo.reader.getBrowserName();
		//setUpDriver(ObjectRepo.reader.getBrowser());
		setUpDriver(bName);
		
		System.out.println("Inside Before method");
	    actionBeforeClass.beforeTestAction(bName,scenarioName,"test");
	}
	
	@After
	public void after(Scenario scenario)
	{
		driver.quit();
		log.info("");
	}
	/*public TestBase()
	{
		prop = new Properties();
		try {
			
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//configfile//config.properties");
			prop.load(ip);
		} 
		
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		catch(IOException e)
    	{
    		e.printStackTrace();
    	}
	}*/
	
	/*@BeforeTest
	@Parameters({"browserType"})
	public void onBeforeTest(String browserType,ITestContext testContext)
	{
		browserID=browserType;
		XMLtestCaseName=testContext.getName();
		//app_URL=prop.getProperty("Website");
		try
		{
			if(XMLtestCaseName.contains("firefox"))
			{
				System.out.println("Inside Before Test class of BASE CLASS: FIREFOX");
                String filePath=System.getProperty("user.dir")+"\\"+ "TestReportsFirefox.html";
                report=new ExtentReports(filePath,true, DisplayOrder.OLDEST_FIRST);
                System.out.println("Inside Before Test class: FIREFOX & Extent Report for" + browserID + "is Initilized");
			}
			
			 else if(XMLtestCaseName.contains("chrome"))
			 {
				 System.out.println("Inside Before Test class for CHROME");
	             String filePath=System.getProperty("user.dir")+"\\"+ "TestReportsChrome.html";
	             report1=new ExtentReports(filePath,true, DisplayOrder.OLDEST_FIRST);
	             System.out.println("Inside Before Test class for CHROME & Extent Report for" + browserID + "is Initilized");
			 }
		}
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}*/
	
	public WebDriver getBrowserObject(String bType) throws Exception
		{
			try
			{
				log.info(bType);
				switch(bType.trim()){
				
				case "Chrome":
					ChromeBrowser chrome=ChromeBrowser.class.newInstance();
					return chrome.getChromeDriver(chrome.getChromeCapabilities());
				
				case "Firefox":
					
					FireFoxBrowser firefox= FireFoxBrowser.class.newInstance();
					return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());
					
				default:
					throw new Exception("Driver not found" + new PropertyFileReader().getBrowserName());
				}
			}
			
			catch(Exception e)
			{
				log.equals(e);
				throw e;
			}
		}
	

	public void setUpDriver(String bType) throws Exception
	{
		
		driver=getBrowserObject(bType);
		log.debug("Initialize Webdriver : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
	}
	
	

}
