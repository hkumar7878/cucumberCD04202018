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
import com.relevantcodes.extentreports.LogStatus;

public class HomePageCarDekho extends TestBase{
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	
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
	
	
	public void verifyHomePageDisplay(String brName)
	{
		boolean flag;
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
		boolean flag;
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
	
	public void hoverOverNewCarMenu(String brName)
	{
		boolean flag=false;
		try
		{
			flag=GenericHelper.hoverOverElement(menuNewCars,driver,dropDownNewCar);
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
	
	public void verifyNewCarMenuOptions(List<String> newCarOptions)
	{
		boolean flag=false;
		List<String> newCarOptions1= new ArrayList<String>();
		try
		{
			newCarOptions1=DropDownHelper.getAllOptionsInDropDown(dropDownNewCar);
			
			System.out.println(newCarOptions1);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
