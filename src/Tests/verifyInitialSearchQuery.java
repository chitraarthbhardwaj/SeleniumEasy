package Tests;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageHelpers.InitialPage;
import PageHelpers.ProductListingPage;


public class verifyInitialSearchQuery extends SetupClasses.DriverHelper
{
		
	@Test
	void testInitialsearchquery() throws IOException
	{
		InitialPage i=new InitialPage();
		ProductListingPage p=new ProductListingPage();
		
		Browser("chrome");
		getDriver().get(readProperty("URL"));
		getDriver().manage().window().maximize();
		getDriver().findElement(By.xpath(i.searchBox)).sendKeys("dress");
		getDriver().findElement(By.xpath(i.searchButton)).click();
		
		if((getDriver().findElement(By.xpath(p.SearchProductQuery)).getText())==("\""+getDriver().findElement(By.xpath(i.searchBox)).getText().toUpperCase()+"\""))
		{
			System.out.println("This search is correct");
		}
			else
		{
		System.out.println("here");
		System.out.println(getDriver().findElement(By.xpath(p.SearchProductQuery)).getText());
		System.out.println((getDriver().findElement(By.xpath(i.searchBox)).getText()));
		}
	}	
	
}
