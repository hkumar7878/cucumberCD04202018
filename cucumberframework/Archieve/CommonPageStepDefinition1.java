package stepDefinitions;

import helpers.Hook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Application_Pages.Adidas_Home_Page;
//import Application_Pages.Men_BaseketBall_Shoes_Page;

public class CommonPageStepDefinition1 {

	public WebDriver driver;
	//Adidas_Home_Page homePage=new Adidas_Home_Page(driver);
	Adidas_Home_Page homePage;
	/*public CommonPageStepDefinition() {
		this.driver = Hook.getDriver();
	}*/
	
	@Test
	@When("^Open a browser and open Adidas online store site$")
	public void i_open_a_browser_and_open_policy_baazzar_site() throws Throwable {
		
		try
		{
		
			driver=	Hook.getDriver();
			homePage=new Adidas_Home_Page(driver);
			System.out.println("Adidas site is opened successfully:Inside CommonDefinitionClass");
			Thread.sleep(3000);
		}
				
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Then("^Verify Adidas online store Home Page$")
	public void Verify_Adidas_Online_Store_Home_Page() throws Throwable {
				
		try
		{
			System.out.println("Inside Adidas Online Store home page verification step:Inside CommonDefinitionClass");
			homePage.verify_Adidas_Logo();
		}
		
		catch(Exception e)
		
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}

}
