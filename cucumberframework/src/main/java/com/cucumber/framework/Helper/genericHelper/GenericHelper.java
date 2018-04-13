package com.cucumber.framework.Helper.genericHelper;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class GenericHelper {

	private static final Logger log=LoggerHelper.getLogger(GenericHelper.class);
	
	public String readValueFromElement(WebElement element)
	{
		if (element==null)
		{
			log.info("Element is null");
			return null;
		}
	
		try
		{
			isDisplayed(element);
		}
		
		catch (Exception ex){
			log.error(ex);
			return null;
		}
		
		String text=element.getText();
		log.info("WebElement value is : " + text);
		return text;
	}
	
	public String readValueFromInput(WebElement element)
	{
		if(null==element)
			return null;
		if(!isDisplayed(element))
			return null;
		String value=element.getAttribute("value");
		log.info("webelement value is : " + value);
		return value;
	}
	
	public boolean isDisplayed(WebElement element)
	{
		try
		{
			element.isDisplayed();
			log.info("Element is displayed " + element);
			return true;
		}
		catch (Exception ex)
		{
			log.info(ex);
			return false;
		}
	}
}
