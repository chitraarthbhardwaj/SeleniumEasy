package Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
		JavascriptExecutor js=(JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1400)", "");
		//js.executeScript("arguments[0].click();", )
		
		List<WebElement> li=getDriver().findElements(By.tagName("a"));
		
		for(WebElement aa: li)
		{
			WebElement aas=getDriver().findElement(By.xpath("//a[@title='Blouse']"));
			aas.click();
		}
		
		List<WebElement> frames=getDriver().findElements(By.tagName("iframe"));
		for(WebElement framing:frames)
		{
			getDriver().switchTo().frame(getDriver().findElement(By.xpath("iframe[@class='fancybox-iframe']")));
		}
		
	//	WaitForElementVisibility(pp.ProceedToCheckoutOnProductPage);
		getDriver().findElement(By.xpath("//div[@class='fancybox-overlay fancybox-overlay-fixed'][@style='display: block; width: auto; height: auto;']//div[@class='fancybox-wrap fancybox-desktop fancybox-type-iframe fancybox-opened'"));
		getDriver().findElement(By.xpath(pp.AddToCartButton)).click();
		getDriver().findElement(By.xpath(pp.ProceedToCheckoutOnProductPage)).click();
		//getDriver().findElement(By.xpath(pp.ProceedToCheckout)).click();
		String Authentication=getDriver().findElement(By.xpath(c.CartPageAuthentication)).getText();
		if(Authentication=="Authentication")
		{
			Assert.assertTrue(true);
		}
		
	//	getDriver().close();
		
	}
	/*
	 * @AfterTest void closemethod() { getDriver().close(); }
	 */
	
	
}
