package CommonFunLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;

public class FunctionLibrary
{
 static  WebDriver driver;
  
  //Open Browser
  public static WebDriver startBrowser() throws Exception{
	  
  if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome"))
  {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kamal.a\\Documents\\MyNewWorkspace\\DataDriven\\CommonJars\\chromedriver.exe");
     driver=new ChromeDriver();
     
  }
  else if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("FireFox"))
  { 
	  
  }
  else if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("IE"))
  {
	  
	
  }
  else 
   {
	System.out.println("Browser value not matching");
   }
  return driver;
}

    	  
      //Open Application
  public static void openApplication(WebDriver driver) throws Exception
  {
	  driver.get(PropertyFileUtil.getValueForKey("url"));
	  driver.manage().window().maximize();
  }
 
  //Wait for Element
  public static void waitForElement(WebDriver driver, String locatortype, String locatorvalue, String waittime)
  {
	  WebDriverWait mywait = new WebDriverWait(driver,Integer.parseInt(waittime));
	  if(locatortype.equalsIgnoreCase("id"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		}	
		else if (locatortype.equalsIgnoreCase("name")) 
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
		}
		else if (locatortype.equalsIgnoreCase("xpath")) 
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		}
	 else
	  {
		System.out.println("Unable to locate for wait for element");
	  }

  }

  //  method for typeAction
  public static void typeAction(WebDriver driver, String locatortype, String locatorvalue, String testdata)
  {
	if(locatortype.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(locatorvalue)).clear();
		driver.findElement(By.id(locatorvalue)).sendKeys(testdata);
	}	
	else if (locatortype.equalsIgnoreCase("name")) 
	{
		driver.findElement(By.name(locatorvalue)).clear();
		driver.findElement(By.name(locatorvalue)).sendKeys(testdata);
	
	}
	else if (locatortype.equalsIgnoreCase("xpath")) 
	{
		driver.findElement(By.xpath(locatorvalue)).clear();
		driver.findElement(By.xpath(locatorvalue)).sendKeys(testdata);
	}
	else{
		System.out.println("Unable to execute typeAction method");
	}
  }
  
  //method for clickAction
  public static void clickAction(WebDriver driver, String locatortype, String locatorvalue)
  {
	  if (locatortype.equalsIgnoreCase("id"))
	  {
	    driver.findElement(By.id(locatorvalue)).click(); 
	  }
	  else if (locatortype.equalsIgnoreCase("name"))
	  {
		  driver.findElement(By.name(locatorvalue)).click();
	  }
	  else if (locatortype.equalsIgnoreCase("xpath"))
	  {
		  driver.findElement(By.xpath(locatorvalue)).click();
	  }
	  else
	  {
		  System.out.println("Unbale to execute ClickAction method");  
	  }
   }

  //closeBrowser
  public static void closeBrowser(WebDriver driver)
  {
	  driver.close();
  }
  public static String generateDate()
  {
	  Date date= new Date();
	  SimpleDateFormat sdf=new  SimpleDateFormat("YYYY_MM_dd_ss");
      return sdf.format(date);
  }
}
