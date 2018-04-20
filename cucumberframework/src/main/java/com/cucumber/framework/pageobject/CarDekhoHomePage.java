package com.cucumber.framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.Wait.WaitHelper;

public class CarDekhoHomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	
	public CarDekhoHomePage()
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
	WebElement dropDownNewCars;
	
	@FindBy(xpath="//a[text()='Used']")
	WebElement dropDownOldCars;
	
	@FindBy(xpath="//a[@title='Sell Car']")
	WebElement lnkSellCar;
	
	

}
