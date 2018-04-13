package stepDefinitions;

import helpers.Hook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Application_Pages.Adidas_Home_Page;
import Application_Pages.Women_TShirt_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class WomenClothingProductPageDefinition {
	Adidas_Home_Page homePage;
	Women_TShirt_Page womenTshirtPage;
	public static WebDriver driver;
	
	
	@Test
	@And("^Hover over Women Menu$")
	public void Hover_Over_Men_Menu() throws Throwable 
	{
		String menuChoice="Women";
		driver=	Hook.getDriver();
		homePage=new Adidas_Home_Page(driver);
		homePage.hover_Over_Menu(menuChoice);		
	}

	@Then("^Verify Women Menu opens$")
	public void Verify_Men_Menu_opens() throws Throwable 
	{
		System.out.println("Inside WOMEN Menu Opening verification");
		homePage.verify_Women_Clothing_Menu_Display();
	}

	@Then("^Click on T Shirts link$")
	public void click_on_T_Shirts_link() throws Throwable 
	{
		System.out.println("Inside clicking on WOMEN Basketball link verification");
		homePage.click_WomenTShirt_Link();
    
	}

	@Then("^verify Women T Shirt page appears$")
	public void verify_Women_T_Shirt_page_appears() throws Throwable 
	{
		System.out.println("Inside clicking on WOMEN TSHIRT page appearance verification");
		womenTshirtPage = new Women_TShirt_Page(driver);
		womenTshirtPage.verify_WomenTshirt_Pg_Header();
  
}

}