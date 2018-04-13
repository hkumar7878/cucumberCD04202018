package com.cucumber.framework.Helper.assertionHelper;

import com.cucumber.framework.Helper.Logger.LoggerHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class VerificationHelper {
	
	private static final Logger log=LoggerHelper.getLogger(VerificationHelper.class);
	
	public static synchronized boolean verifyElementPresent(WebElement element)
	{
		boolean isDisplayed=false;
		try{
			isDisplayed=element.isDisplayed();
		}		
		catch(Exception ex) {
			log.error("Element not found " + ex);	
		}
		
		return isDisplayed;
	}
	 
	public static synchronized boolean verifyElementNotPresent(WebElement element)
	{
		boolean isDisplayed=false;
		try{
			element.isDisplayed();
		}		
		catch(Exception ex) {
			log.error("Element not found " + ex);	
			isDisplayed=true;
		}
		
		return isDisplayed;
	}
	
	public static synchronized boolean verifyTextEquals(WebElement element, String expectedText)
	{
		boolean flag=false;
		try
		{
			String actualText=element.getText();
			if(expectedText.equals(actualText))
				return flag=true;
			else
				return flag;
		}
		
		catch (Exception ex)
		{
			log.info("Element not found " + ex);
			return flag;
		}
	}
}
