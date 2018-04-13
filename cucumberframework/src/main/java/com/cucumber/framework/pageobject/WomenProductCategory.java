package com.cucumber.framework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.Wait.WaitHelper;

public class WomenProductCategory {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(WomenProductCategory.class);
	WaitHelper waitHelper;
	
	public String Black = "Black";
	public String Orange = "Orange";
	public String Yellow = "Yellow";
	
	@FindBy(xpath="//*[@id='layered_block_left']/p")
	WebElement catalogTextObj;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
	WebElement productAddedSucessfully;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[4]/div/div[2]/div[2]/a[1]/span")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckOut;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li")
    List<WebElement> totalProducts;
	
	public WomenProductCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		waitHelper.waitForElement(driver,20,catalogTextObj);
}

	public int getTotalProducts(){
		return totalProducts.size();
	}
	
	public void selectColor(String color)
	{
		log.info("Selecting color " + color);
		driver.findElement(By.xpath("//a[contains(text(),'"+color+"')]/parent::*/preceding-sibling::input[1]")).click();
	}
	
}
