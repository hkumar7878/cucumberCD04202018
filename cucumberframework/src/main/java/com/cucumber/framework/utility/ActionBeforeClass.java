package com.cucumber.framework.utility;

import com.cucumber.framework.Helper.TestBase.TestBase;

public class ActionBeforeClass extends TestBase{
	
	public void beforeTestAction(String browserType,String scenarioName,String tcDesc)
	
	{
		browserID=browserType;
		if(browserID.contains("Firefox"))
        {
            FF_logger=report.startTest(scenarioName, tcDesc);
            
        }

        else if(browserID.contains("Chrome"))
        {
            CH_logger=report1.startTest(scenarioName, tcDesc);
        }
	}

}
