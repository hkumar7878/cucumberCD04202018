package com.cucumber.framework.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.Helper.Alert.AlertHelper;
import com.cucumber.framework.Helper.Logger.LoggerHelper;
import com.cucumber.framework.Helper.TestBase.TestBase;
import com.cucumber.framework.Helper.Wait.WaitHelper;
import com.cucumber.framework.Helper.genericHelper.GenericHelper;
import com.cucumber.framework.utility.ApplicationLib;
import com.relevantcodes.extentreports.LogStatus;

public class PageSearchResults extends TestBase {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	GenericHelper generichelper = new GenericHelper();
	// ApplicationLib applicationLibObj= new ApplicationLib();
	AlertHelper alertHelper;
	static boolean flag;
	public static String err_Msg;

	public PageSearchResults(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 20, maintitle);
	}

	@FindBy(xpath = "//main[@class='maintitle']")
	WebElement maintitle;

	@FindBy(xpath = "//main[@class='maintitle']//h1")
	WebElement hdTxtSearchResult;

	/**
	 * 
	 * Following method will verify the results of selected budget type and type
	 * of vehicle selected from car dekho home page
	 */

	public void verifyResults(String brName, String expBudgetVal,String expVehcileType) {
		alertHelper = new AlertHelper(driver);
		
		List<String> expValues=Arrays.asList(expBudgetVal,expVehcileType);
		String tempString="";

		try {
			flag = alertHelper.isAlertPresent();
			if (flag) {
				String atlTxt = alertHelper.getAlertText();
				System.out.println("Alert text is " + atlTxt);
				if (brName.contains("Chrome")) {
					CH_logger.log(LogStatus.PASS,"There are no search results for this selection");
				}
				return;
			}

			else 
			{
				String hdTxt = generichelper.readValueFromElement(hdTxtSearchResult);
				for (int i = 0; i < expValues.size(); i++) 
				{
					String searchOptionTxt=expValues.get(i);
					flag = ApplicationLib.verifyHeader(hdTxt, searchOptionTxt);
						if (!flag) 
							{
								CH_logger.log(LogStatus.FAIL, expValues.get(i) + "not displayed successfully");
								break;
							}
						tempString=tempString+searchOptionTxt;
				}
				
				if(flag)
					CH_logger.log(LogStatus.PASS, tempString + "displayed successfully");
				
				
			}
		}

		catch (Exception e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
	}
}
