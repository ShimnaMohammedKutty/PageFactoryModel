package pagefactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pfpages.PfHomePage;
import pfpages.PfSearchPage;





public class PfSearch {
	
	WebDriver driver;
	Properties prop;
	PfHomePage hpage;
	PfSearchPage spage;

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void setup()
	{
	
	try
	{
	 prop=new Properties();
	 File propFile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\pagefactory\\data.properties");
	 FileReader fr=new FileReader(propFile);
	 prop.load(fr);
	}catch(IOException e)
	{
		e.printStackTrace();
	}
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	
	}
	
	@Test(priority=1)
	public void verifySearchForExistingProduct()
	{
		hpage=new PfHomePage(driver);
		hpage.enterProduct(prop.getProperty("validproduct"));
		driver=hpage.clickSearchButton();
		
		spage=new PfSearchPage(driver);
	    Assert.assertTrue(spage.validProductIsDisplayed());
	}
	
	
	@Test(priority=2)
	public void verifySearchForNonExistingProduct()
	{
		hpage=new PfHomePage(driver);
		hpage.enterProduct(prop.getProperty("invalidproduct"));
		driver=hpage.clickSearchButton();
		
		spage=new PfSearchPage(driver); 
		 
		 String expected="There is no product that matches the search criteria.";
		
		 Assert.assertEquals(spage.invalidProductMessage(), expected);
	}
	
	@Test(priority=3)
	public void verifySearchWithOutProduct()
	{
		
		hpage=new PfHomePage(driver);
		driver=hpage.clickSearchButton();
		
				 
		spage=new PfSearchPage(driver); 
		 
		 String expected="There is no product that matches the search criteria.";
		
		 Assert.assertEquals(spage.invalidProductMessage(), expected);
	}

}
