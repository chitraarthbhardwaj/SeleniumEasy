package SetupClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverHelper implements DriverTestCase
{
	private WebDriver driver=null;
	Properties p=new Properties();
	
	
	protected String readProperty(String key) throws IOException
	{
		
		try 
		{
			FileInputStream fis=new FileInputStream("D:\\Eclipse\\SeleniumEasy\\src\\Resources\\config.properties");
			p.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void ClickOn(String element)
	{		
		if(element.startsWith("\\"))
			getDriver().findElement(By.xpath(element)).click();
		
		else if(element.startsWith("css="))
			getDriver().findElement((By.cssSelector(element))).click();
		else if(element.contains("@id="))
			getDriver().findElement(By.id(element)).click();
	}
	
	public void WaitForElement(String element)
	{	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	public void WaitForPageLoad()
	{
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) 
		{

			e.printStackTrace();
		}		
	}

	public void WaitForElementVisibility(String element) 
	{
		getDriver().findElement(By.xpath(element));
	}
	
	void setProperty(String key,String value) throws FileNotFoundException
	{
		FileInputStream fiss=new FileInputStream("D:\\Eclipse\\SeleniumEasy\\src\\Resources\\config.properties");
		try {
			p.load(fiss);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		p.setProperty(key, value);
	}
	public void Browser(String browser) 
	{
	if(browser=="chrome")
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\SeleniumEasy\\src\\Resources\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browser=="ff")
	{
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\coolc\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-firefox-driver\\2.45.0\\selenium-firefox-driver-2.45.0-sources.jar");

		driver=new FirefoxDriver();
	}
	else if(browser=="safari")
	{
		System.setProperty("webdriver.safari.driver", "C:\\Users\\coolc\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-safari-driver\\2.45.0\\selenium-safari-driver-2.45.0-sources.jar");
		driver=new SafariDriver();
	}
		
	}

	
}
