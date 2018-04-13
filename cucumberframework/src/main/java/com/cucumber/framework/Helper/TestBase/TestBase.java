package com.cucumber.framework.Helper.TestBase;

import java.util.concurrent.TimeUnit;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.configreader.PropertyFileReader;
import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.configuration.browser.ChromeBrowser;
import com.cucumber.framework.configuration.browser.FireFoxBrowser;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class TestBase {
	
	private final Logger log=LoggerHelper.getLogger(TestBase.class);
	public static WebDriver driver;
	
	/*public WebDriver getBrowserObject(BrowserType bType) throws Exception
	//public WebDriver getBrowserObject(String bType) throws Exception
	{
		try
		{
			log.info(bType);
			switch(bType){
			
			case Chrome:
				ChromeBrowser chrome=ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());
			
			case Firefox:
				
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
	}*/
	
	/*//public void setUpDriver(BrowserType bType) throws Exception
	public void setUpDriver(String bType) throws Exception
	{
		
		driver=getBrowserObject(bType);
		log.debug("Initialize Webdriver : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}*/
	
	/*@Before()
	public void before() throws Exception
	{
		System.out.println("Starting of Before method");
		ObjectRepo.reader=new PropertyFileReader();
		String bName=ObjectRepo.reader.getBrowserName();
		//setUpDriver(ObjectRepo.reader.getBrowser());
		setUpDriver(bName);
		log.info(ObjectRepo.reader.getBrowser());
		System.out.println("Inside Before method");
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
	
	//public void setUpDriver(BrowserType bType) throws Exception
	public void setUpDriver(String bType) throws Exception
	{
		
		driver=getBrowserObject(bType);
		log.debug("Initialize Webdriver : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
	}
	
	@Before()
	public void before() throws Exception
	{
		System.out.println("Starting of Before method");
		ObjectRepo.reader=new PropertyFileReader();
		String bName=ObjectRepo.reader.getBrowserName();
		//setUpDriver(ObjectRepo.reader.getBrowser());
		setUpDriver(bName);
		//log.info(ObjectRepo.reader.getBrowser());
		System.out.println("Inside Before method");
	}
	
	@After
	public void after(Scenario scenario)
	{
		driver.quit();
		log.info("");
	}

}
