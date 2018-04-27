package com.cucumber.framework.Helper.genericHelper;

import java.util.ArrayList;
import java.util.List;

import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericHelper{

	private static final Logger log=LoggerHelper.getLogger(GenericHelper.class);
	public static String exception_Msg;
	
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
	
	public static boolean isDisplayed(WebElement element)
	{
		try
		{
			element.isDisplayed();
			log.info("Element is displayed " + element.getText().toString());
			return true;
		}
		catch (Exception ex)
		{
			log.info(ex);
			return false;
		}
	}
	
	
	public static boolean click(WebElement element)
	{
		boolean flag=false;
		try
		{
		//if(element.isDisplayed())
			
		if(GenericHelper.isDisplayed(element))
			{
				element.click();
				System.out.println(element.getText().toString() + "is clicked successfully");
				flag=true;		
		}
		else
			{
				throw new RuntimeException("Throwing run time exception for Element is not displayed" + element.getTagName().toString());
			}
		}
		
		catch (RuntimeException e)
		{
			System.out.println(e.getMessage());
			log.info("Throwing run time exception for Element is not displayed for elemenet  " + element.getTagName().toString());
			exception_Msg=e.getMessage()+ element.getTagName().toString();
			
		}
		return flag;
	}
	
	public static boolean hoverOverElement(WebElement we,WebDriver dr,List<WebElement> dropDown)
	{
		boolean flag=false;	
		try
		{
			Actions act = new Actions(dr);
			act.moveToElement(we).build().perform();
			//Thread.sleep(3000);
			
			if(dropDown.size()>1)
				flag=true;	
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
	
	public static boolean defaultSelection(WebElement we)
	{
		boolean flag=false;
		try
		{
		if( isDisplayed (we))
			//&& we.isSelected()
			return true;
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
		
	}
}
