package com.cucumber.framework.configreader;

import java.util.Properties;
import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.utility.ResourceHelper;
public class PropertyFileReader implements ConfigReader{
	
	private Properties prop=null;
	
	public PropertyFileReader()
	{
		prop= new Properties();
		try
		{
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getWebSiteName()
	{
		return prop.getProperty("Website");
	}
	
	public String getBrowserName()
	{
		return prop.getProperty("Browser");
	}
	
	public int getPageLoadTimeOut()
	{
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	
	@Override
	public BrowserType getBrowser() {
		
		//BrowserType browserValue=BrowserType.valueOf(prop.getProperty("Browser"));
		
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebSite() {
		// TODO Auto-generated method stub
		return prop.getProperty("Website");
	}

	@Override
	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
