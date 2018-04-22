package com.cucumber.framework.Helper.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseSetUp {
	
	public static Properties prop=null;
	String browserID=null;
	String XMLtestCaseName=null;
	String app_URL=null;
	
	public BaseSetUp()
	{
		prop = new Properties();
		try {
			
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//configfile//config.properties");
			prop.load(ip);
		} 
		
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		catch(IOException e)
    	{
    		e.printStackTrace();
    	}
	}
	
	/*@BeforeTest
	@Parameters({"browserType"})
	public void onBeforeTest(String browserType,ITestContext testContext)
	{
		browserID=browserType;
		XMLtestCaseName=testContext.getName();
		app_URL=prop.getProperty("Website");
		try
		{
			if(XMLtestCaseName.contains("firefox"))
			{
				
			}
			
			 else if(XMLtestCaseName.contains("chrome"))
			 {
				 
			 }
		}
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}*/

}
