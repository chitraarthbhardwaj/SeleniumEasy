package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageHelpers.InitialPage;

public class verifyNewsLetter extends SetupClasses.DriverHelper
{
	@Test
	public void testNewsletter() throws IOException
	{
		InitialPage i=new InitialPage();
		Browser("chrome");
		getDriver().get(readProperty("URL"));
		getDriver().findElement(By.xpath(i.NewsLetter)).sendKeys("gevira6043@5sword.com");
		ClickOn(i.submitNewsLetter);
		
		WaitForPageLoad();
		WaitForPageLoad();
		
		if(getDriver().findElement(By.xpath(i.alertnewssuccess)).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("yes");
		}
		
		
		
		
	}
	
	
}
