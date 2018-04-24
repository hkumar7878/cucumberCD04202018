package com.cucumber.framework.Helper.DropDown;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.framework.Helper.Logger.LoggerHelper;








import com.cucumber.framework.Helper.genericHelper.GenericHelper;

import org.apache.log4j.Logger;
public class DropDownHelper {

	private WebDriver driver;
	private final Logger Log=LoggerHelper.getLogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver)
	{
		this.driver=driver;
		Log.debug("DropDownHelper : " + this.driver.hashCode());
	}
	
	 

	
	
	public void SelectUsingVisiableValue(WebElement element,String visibleValue)
	{
		Select select  = new Select(element);
		select.selectByVisibleText(visibleValue);
		Log.info("Locator : " + element + "Value : " + visibleValue);
	}
	
	public String getSelectedValue(WebElement element)
	{
		String value=new Select(element).getFirstSelectedOption().getText();
		Log.info("WebElement : " +element + " value : " +value);
		return value;
	}
	
	/*public List getAllDropDownValues(WebElement locator)
	{
		Select select = new Select(locator);
		java.util.List<WebElement> elementlist= select.getOptions();
		List<String> valueList= new LinkedList<>();
		
		return valueList;
		
	}*/
	
	public List<String> getAllOptionsInDropDown_Select(WebElement dropDownElement)
	{
		List<String> dropDownValues= new ArrayList<String>();
		List<WebElement> dropDownOptions= new ArrayList<WebElement>();
		boolean flag=false;
		flag=GenericHelper.isDisplayed(dropDownElement);
		if(flag)
		{
			flag=GenericHelper.click(dropDownElement);
			if(flag)
			{
				Select sel= new Select(dropDownElement);
				dropDownOptions=sel.getOptions();
				for (WebElement we:dropDownOptions)
				{
					dropDownValues.add(we.getText());
				}
			}
			
			else
				throw new RuntimeException("Could not click the webelement " + dropDownElement.getText().toString());
		}
		
		
		else
			throw new RuntimeException("Could not click on dropdown : " + dropDownElement);
		return dropDownValues;
	}
	
	public static List<String> getAllOptionsInDropDown(List<WebElement> dropDown)
	{
		List<String> dropDownValues= new ArrayList<String>();
		try
		{
		for(WebElement we: dropDown)
			{
				dropDownValues.add(we.getText());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return dropDownValues;
	}
}
