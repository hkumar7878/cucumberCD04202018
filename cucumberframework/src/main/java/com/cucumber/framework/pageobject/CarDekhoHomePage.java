package com.cucumber.framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;

public class CarDekhoHomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	GenericHelper generichelper= new GenericHelper();
	
	public CarDekhoHomePage(WebDriver driver)
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
	
	
	public void verifyHomePageDisplay()
	{
		boolean flag;
		try
		{
			log.info("Checking Car Dekho home page");
			flag=generichelper.isDisplayed(companyLogo);
			Assert.assertTrue(flag, "Car dekho home page is not displayed");
			System.out.println("Car dekho home page is displayed");
		}
		
		catch (Exception e)
		{
			e.getMessage();
			System.out.println(e.getMessage());
		}
	}
	
	public void verifyNewCarDropdown()
	{
		boolean flag;
		try
		{
			log.info("Checking New Cars drop down");
			flag=generichelper.isDisplayed(menuNewCars);
			Assert.assertTrue(flag, "New Cars drop down is not displayed");
			System.out.println("New Cars drop down is displayed");
		}
		
		catch(Exception e)
		{
			e.getMessage();
			System.out.println(e.getMessage());
		}
	}
	

}
