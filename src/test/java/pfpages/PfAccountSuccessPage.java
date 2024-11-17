package pfpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PfAccountSuccessPage {
	
WebDriver driver;
	
	public PfAccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountMenu;
	
	@FindBy(xpath="//li[@class='dropdown open']//li/a[text()='Logout']")
	WebElement myAccountLogoutOption;
	
	@FindBy(linkText="Logout")
	 WebElement displayLogout;
	
	public boolean logoutOptionIsDisplayed()
	{
      
       return displayLogout.isDisplayed();
	}

	
	public void cliclOnMyAccountOption()
	{
		myAccountMenu.click();
	}
	
	public void cliclOnMyAccountLogoutOption()
	{
		myAccountLogoutOption.click();
	}
}
