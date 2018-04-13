package com.cucumber.framework.Helper.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import com.cucumber.framework.Helper.Logger.LoggerHelper;

public class WaitHelper {
	
	public WebDriver driver;
	private Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
		log.debug("WaitHelper : " + this.driver.hashCode());
	}
	
	public WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMillSec)
	{
		log.debug("");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMillSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	
	public void waitForElementVisible(WebElement locator, int timeOutInSeconds,int pollingEveryInMillSec )
	{
		log.info(locator);
		WebDriverWait wait= getWait(timeOutInSeconds, pollingEveryInMillSec);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	public WebElement waitForElement(WebDriver driver,long time, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElement(WebDriver driver,WebElement element, long timeout)
	{
		WebDriverWait wait= new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element not found..." + element.getText());
	}

}
