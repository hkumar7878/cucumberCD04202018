package com.cucumber.framework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumber.framework.utility.ResourceHelper;

/**
 * 
 * @author hiteshg
 *
 */

public class ChromeBrowser {
	
	public Capabilities getChromeCapabilities()
	{
		ChromeOptions option= new ChromeOptions();
		option.addArguments("start-maximized");
		DesiredCapabilities chrome=DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		return chrome;
	}
	
	public WebDriver getChromeDriver(Capabilities cap)
	{
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/driver/chromedriver.exe"));
		return new ChromeDriver(cap);
	}

}
