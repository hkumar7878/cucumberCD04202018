package com.cucumber.framework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumber.framework.utility.ResourceHelper;

/**
 * 
 * @author hiteshg
 *
 */

public class FireFoxBrowser {

	public Capabilities getFirefoxCapabilities()
	{
		
		DesiredCapabilities firefox=DesiredCapabilities.firefox();
		FirefoxProfile profile= new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		return firefox;
		
	}
	
	public WebDriver getFirefoxDriver(Capabilities cap)
	{
		System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/driver/chromedriver.exe"));
		return new FirefoxDriver(cap);
	}
}
