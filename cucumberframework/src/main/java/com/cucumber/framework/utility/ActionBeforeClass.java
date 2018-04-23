package com.cucumber.framework.utility;

import com.cucumber.framework.Helper.TestBase.TestBase;

public class ActionBeforeClass extends TestBase{
	
	public void beforeTestAction(String browserType,String scenarioName,String tcDesc)
	
	{
		
		try{
		browserID=browserType;
		if(browserID.contains("Firefox"))
        {
            System.out.println("Inside beforeTestAction method and trying to start the report test");
			FF_logger=report.startTest(scenarioName, tcDesc);
            
        }

        else if(browserID.contains("Chrome"))
        {
        	System.out.println("Inside beforeTestAction method and trying to start the report test");
        	CH_logger=report1.startTest(scenarioName, tcDesc);
        }
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
