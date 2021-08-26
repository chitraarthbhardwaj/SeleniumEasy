package Tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageHelpers.CartPage;
import PageHelpers.InitialPage;
import PageHelpers.ProductListingPage;
import PageHelpers.ProductPage;

public class verifyBuyAProduct extends SetupClasses.DriverHelper
{
	@Test
	public void testBuyAProduct() throws IOException
	{
		InitialPage i=new InitialPage();
		ProductListingPage p=new ProductListingPage();
		ProductPage pp=new ProductPage();
		CartPage c=new CartPage();

		
		Browser("chrome");
		getDriver().get(readProperty("URL"));
		getDriver().manage().window().maximize();
		getDriver().findElement(By.xpath(i.searchBox)).sendKeys("dress");
		getDriver().findElement(By.xpath(i.searchButton)).click();
		WaitForPageLoad();
		getDriver().findElement(By.xpath(p.SearchResults+"//a[@title='Blouse']")).click();
		WaitForElementVisibility(c.AddToCartModal);
		getDriver().findElement(By.xpath(c.AddToCartModal)).click();
		getDriver().findElement(By.xpath(pp.ProceedToCheckout)).click();
		getDriver().findElement(By.xpath(pp.ProceedToCheckout)).click();
		String Authentication=getDriver().findElement(By.xpath(c.CartPageAuthentication)).getText();
		if(Authentication=="Authentication")
		{
			Assert.assertTrue(true);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
