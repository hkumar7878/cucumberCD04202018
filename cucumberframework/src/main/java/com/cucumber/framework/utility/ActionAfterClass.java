package com.cucumber.framework.utility;

import com.cucumber.framework.Helper.TestBase.TestBase;

public class ActionAfterClass {
	TestBase testBaseObj;
	
	public void actionAfterTest(String scenarioName, String browserID)
	{
		
		if(browserID.contains("FireFox"))
		{
			TestBase.report.endTest(testBaseObj.FF_logger);
			TestBase.report.flush();
			System.out.println("Extent report is flushed for Firefox");
		}
		
		else if (browserID.contains("Chrome"))
		{
			TestBase.report1.endTest(testBaseObj.CH_logger);
			TestBase.report1.flush();
			System.out.println("Extent report is flushed for Chrome");
		}
	}
	

}
