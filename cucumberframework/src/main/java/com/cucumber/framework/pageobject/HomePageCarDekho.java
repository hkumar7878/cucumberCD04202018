package com.cucumber.framework.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.DropDown.DropDownHelper;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.cucumber.framework.utility.ApplicationLib;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageCarDekho extends TestBase{
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	static boolean flag;
	
	public HomePageCarDekho(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		waitHelper.waitForElement(driver,20,companyLogo);
	}
	
	@FindBy(xpath="//a[@title='CarDekho.com - Best place to buy New and Used Cars in India']")
	WebElement companyLogo;
	
	@FindBy(xpath="//a[@title='New Cars']")
	WebElement menuNewCars;
	
	@FindBy(xpath="//a[text()='Used']")
	WebElement menuOldCars;
	
	@FindBy(xpath="//a[@title='Sell Car']")
	WebElement lnkSellCar;
	
	@FindBy(xpath="//a[@title='New Cars']//following-sibling::div/ul/li")
    List<WebElement> dropDownNewCar;
	
	@FindBy(xpath="//a[@title='New Cars']//following-sibling::div/ul/li")
    WebElement dropDownOption_SearchNewCar;
	
	@FindBy(xpath="//li[@id='homeNewCarTab']")
    WebElement tabNewCar;
	
	@FindBy(xpath="//label[@id='searchNewCarByBudgetInputDiv']")
    WebElement radiabBtnByBudget;
	
	@FindBy(xpath="//label[@id='searchNewCarByBudgetInputDiv']")
    WebElement dropDownSelectBudget;
	
	@FindBy(xpath="//select[@id='newCarVehicleTypeSelect']")
    WebElement dropDownAllVehicleType;
	
	public void verifyHomePageDisplay(String brName)
	{
		//boolean flag;
		try
		{
			log.info("Checking Car Dekho home page");
			flag=generichelper.isDisplayed(companyLogo);
			Assert.assertTrue(flag, "Car dekho home page is not displayed");
			System.out.println("Car dekho home page is displayed");
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, "Home Page is displayed");
			}
		}
		
		catch (Exception e)
		{
			e.getMessage();
			System.out.println(e.getMessage());
		}
	}
	
	public void verifyNewCarDropdown(String brName)
	{
		//boolean flag;
		try
		{
			
			log.info("Checking New Cars drop down");
			flag=generichelper.isDisplayed(menuNewCars);
			Assert.assertTrue(flag, "New Cars drop down is not displayed");
			System.out.println("New Cars drop down is displayed");
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, "New Car drop down is displayed");
			}
		}
		
		catch(Exception e)
		{
			e.getMessage();
			System.out.println(e.getMessage());
			CH_logger.log(LogStatus.FAIL, "New Car drop down is NOT displayed");
		}
	}
	
	public void hoverOverNewCarMenu(String brName) throws InterruptedException
	{
		//boolean flag=false;
		try
		{
			flag=GenericHelper.hoverOverElement(menuNewCars,driver,dropDownNewCar);
			waitHelper.waitForElement(driver, dropDownOption_SearchNewCar, 10);
			Assert.assertTrue(flag,"Could not hover over New Car menu");
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, "Hovered over New Car drop down successfully");
			}
			
		}
		
		catch(RuntimeException e)
		{
			e.getMessage();
			System.out.println(e.getMessage());
			CH_logger.log(LogStatus.FAIL, "Could not hover over New Car Menu");
		}
	}
	
	public void verifyNewCarMenuOptions(List<String> newCarOptions,String brName)
	{
		//boolean flag=false;
		List<String> newCarOptions1= new ArrayList<String>();
		try
		{
			newCarOptions1=DropDownHelper.getAllOptionsInDropDown(dropDownNewCar);
			
			flag=ApplicationLib.campareStringLists(newCarOptions, newCarOptions1);
			System.out.println("Value for fetched car values from application" + newCarOptions1);
			Assert.assertTrue(flag,"Incorrect values are shown in New Car drop down");
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, "Expeceted values are shown in New Car drop down");
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			CH_logger.log(LogStatus.FAIL, "Expeceted values are NOT shown in New Car drop down");
		}
	}
	
	public void verifyNewCarTabSelection(String brName)
	{
		try
		{
			
			flag=GenericHelper.defaultSelection(tabNewCar);
			Assert.assertTrue(flag,"New Car tab is not selected by default");
			System.out.println("New Car tab is selected by default");
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, "New Car tab is selected by default");
			}
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			CH_logger.log(LogStatus.FAIL, "New Car tab is not selected by default");
		}
	}
	
	public void verifyByCarRadialBtnSelection(String brName)
	{
		try
		{
			
			flag=GenericHelper.defaultSelection(radiabBtnByBudget);
			Assert.assertTrue(flag,"By Car radial button is not selected by default");
			System.out.println("By Car radial button is selected by default");
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, "By Car radial button is selected by default");
			}
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			CH_logger.log(LogStatus.FAIL, "By Car radial is not selected by default");
		}
	}
	
	public void verifyDefaultBudgetDropDownValue(String brName,String defaultVal)
	{
		String defActBudgetVal=null;
		try
		{
			defActBudgetVal=DropDownHelper.getSelectedValue(dropDownSelectBudget);
			Assert.assertEquals(defActBudgetVal, defaultVal);
			System.out.println(defActBudgetVal + "value is matching with exp value i.e " + defaultVal);
			
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, defActBudgetVal + "Correct Budget drop down is being displayed");
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			if(brName.contains("Chrome"))
			{
				CH_logger.log(LogStatus.PASS, defActBudgetVal + "Correct Budget drop down is not being displayed");
			}
		}
	}

}
