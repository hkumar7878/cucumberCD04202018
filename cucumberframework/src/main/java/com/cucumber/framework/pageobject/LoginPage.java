package com.cucumber.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.cucumber.framework.configreader.ObjectRepo;

public class LoginPage {
	
	public WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waithelper;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement lnk_signIn;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement txt_EmailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement txt_Password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement btn_sign_In;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement registration;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement createAnAccount;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement txt_SuccessMsgObject;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, lnk_signIn, ObjectRepo.reader.getExplicitWait());
	}
	
	public void clickOnSignLink()
	{
		log.info("Clicking on Signing link....");
		lnk_signIn.click();
	}
	
	public void enterEmailAddress(String emailAddress)
	{
		log.info("Entering email address" + emailAddress);
		txt_EmailAddress.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password)
	{
		log.info("Entering email address" + password);
		txt_Password.sendKeys(password);
	}
	
	public HomePage clickOnSignInBtn()
	{
		log.info("Clicking on Signin button");
		btn_sign_In.click();
		return new HomePage(driver);
	}
	
	public boolean verifySuccessLoginMsg()
	{
		return new GenericHelper().isDisplayed(txt_SuccessMsgObject);
	}
	
	public void enterRegistrationEmail(){
		String email = System.currentTimeMillis()+"@gmail.com";
		log.info("entering registration email.."+email);
		registration.sendKeys(email);	
	}
	
	public RegistrationPage clickOnCreateAnAccount(){
		createAnAccount.click();
		return new RegistrationPage(driver);
	}

}
