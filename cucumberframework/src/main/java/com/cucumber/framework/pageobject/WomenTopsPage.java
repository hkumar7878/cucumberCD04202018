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
import com.cucumber.framework.Helper.genericHelper.GenericHelper;

public class WomenTopsPage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(WomenTopsPage.class);
	WaitHelper waitHelper;
	GenericHelper genericHelperObj;
	
	public String Black = "Black";
	public String Orange = "Orange";
	public String Yellow = "Yellow";
	
	@FindBy(xpath="//*[@id='categories_block_left']/h2")
	WebElement txtTops;
	
	@FindBy(xpath="//[@id='center_column']/ul/li")
    List<WebElement> totalProducts;
	
	public WomenTopsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		waitHelper.waitForElement(driver,20,txtTops);
}

	public void verifyWomenTopPageHeader()
	{
		
		if(genericHelperObj.isDisplayed(txtTops))
		{
			log.info("Tops page is displayed");
			System.out.println("Tops page is displayed");
		}
		else
		{
			log.info("Tops page is not displayed");
			System.out.println("Tops page is not displayed");
		}
		
	}
	
	
	public void selectColor(String color)
	{
		log.info("Selecting color " + color);
		driver.findElement(By.xpath("//a[contains(text(),'"+color+"')]/parent::*/preceding-sibling::input[1]")).click();
	}
	
	public int getTotalProducts(){
		return totalProducts.size();
	}
	
}
