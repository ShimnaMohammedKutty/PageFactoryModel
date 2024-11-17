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

import pfpages.PfAccountLogoutPage;
import pfpages.PfAccountSuccessPage;
import pfpages.PfHomePage;
import pfpages.PfLoginPage;

public class PfLogout {
	
	WebDriver driver;
	Properties prop;
	PfHomePage hpage;
	PfLoginPage lpage;
	PfAccountSuccessPage accountpage;
	PfAccountLogoutPage logoutpage;
	
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
	public void verifyLogoutFromMyAccountMenu()
	{
		
		hpage=new PfHomePage(driver);
		hpage.clickMyAccount();
		driver=hpage.loginClick();
		
		lpage=new PfLoginPage(driver);
		lpage.enterEmailField(prop.getProperty("email"));
		lpage.enterPasswordField(prop.getProperty("epassword"));
		driver=lpage.clickOnLoginButton();
		
		accountpage=new PfAccountSuccessPage(driver);
		accountpage.logoutOptionIsDisplayed();
		accountpage.cliclOnMyAccountOption();
		accountpage.cliclOnMyAccountLogoutOption();
		
		String expectedTitle="Account Logout";
		String actualTitle =driver.getTitle();
		
		Assert.assertEquals(actualTitle,expectedTitle);
		
		logoutpage=new PfAccountLogoutPage(driver);
		logoutpage.clickOnMyAccountDropMenu();
		
		Assert.assertTrue(logoutpage.displayStatusOfLoginOption());
		
	}

}
