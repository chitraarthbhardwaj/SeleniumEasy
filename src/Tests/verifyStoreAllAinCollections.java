package Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class verifyStoreAllAinCollections extends SetupClasses.DriverHelper
{
		@Test
		void testStoreAllAinCollections() throws IOException
		{
			Browser("chrome");
			getDriver().get(readProperty("URL"));
			List<WebElement> list=getDriver().findElements(By.tagName("a"));
			
			Iterator<WebElement> it=list.iterator();
			
			while(it.hasNext())
			{
				System.out.println(list);
			}
			
			
			
		}
}
