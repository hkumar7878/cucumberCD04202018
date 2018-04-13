package com.cucumber.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.Wait.WaitHelper;
public class HomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	
	String Tshirts = "T-shirts";
	String Blouses = "Blouses";
	String CasualDresses = "Casual Dresses";

	
	@FindBy(xpath="//a[@title='Women']")
	public WebElement womenMenu;
	
	@FindBy(xpath="//[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;
	
	
	@FindBy(xpath="//[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tshirtsMenu;
	
	@FindBy(xpath="//[@id='center_column']/div/div[1]/ul/li[1]/a/span")
	WebElement orderHistoryAndDetailsLink;
	
	@FindBy(xpath="//[@id='center_column']/div/div[1]/ul/li[3]/a/span")
	WebElement myAddresses;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, womenMenu,ObjectRepo.reader.getExplicitWait());
		waitHelper.waitForElement(driver,20,womenMenu);
}
	
	public WomenProductCategory clickOnMenu(WebElement element){
		log.info("clickin on : "+element.getText());
		element.click();
		return new WomenProductCategory(driver);
}

}
