package pfpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PfAccountLogoutPage {
	
	WebDriver driver;
	
	public PfAccountLogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	WebElement myAccountLoginOption;
	
	public void clickOnMyAccountDropMenu()
	{
		myAccountDropMenu.click();
	}
	
	public boolean displayStatusOfLoginOption()
	{
		return myAccountLoginOption.isDisplayed();
		
	}
	
	

}
