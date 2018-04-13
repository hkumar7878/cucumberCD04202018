/**
 * 
 */
package helpers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Application_Pages.Adidas_Home_Page;
import cucumber.api.java.After;
import cucumber.api.java.Before;


/**
 * @author Hitesh
 *
 */
public class Hook {

	public static WebDriver driver;
	Adidas_Home_Page homePage;
	//@Before("@setUp")
	@Before( order =0)
	public void setUp()
	{
		
		System.out.println("This will run BEFORE any scenario defined in the feature file");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowsersExe//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://shop.adidas.co.in/");
		
		System.out.println("Inside BEFORE METHOD and browser is initilized successfully");
	}
	@Before( order = 1)
public void i_open_a_browser_and_open_policy_baazzar_site() throws Throwable {
		
		try
		{
		
			driver=	Hook.getDriver();
			homePage=new Adidas_Home_Page(driver);
			System.out.println("Adidas site is opened successfully:INSIDE BEFORE METHOD");
			Thread.sleep(3000);
		}
				
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	@Before( order = 2)
	public void Verify_Adidas_Online_Store_Home_Page() throws Throwable {
	
	try
	{
		System.out.println("Inside Adidas Online Store home page verification step:INSIDE BEFORE METHOD");
		homePage.verify_Adidas_Logo();
	}
	
	catch(Exception e)
	
	{
		System.out.println(e.getMessage());
		e.getStackTrace();
	}
}
	
	//@After("@setUp")
	@After()
	public void tearDown()
	{
		driver.quit();
		System.out.println("INSIDE AFTER METHOD and This will run AFTER any scenario defined in the feature file");
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}