package pfpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PfHomePage {

WebDriver driver;
	
	public PfHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(linkText="Register")
	WebElement register ;
	
	@FindBy(name="search")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchClick;
	
	public void clickMyAccount()
	{
		
		myAccount.click();
	
		
	}
	public WebDriver loginClick()
	{
	
		login.click();
		return driver;
	}
	public WebDriver registerClick()
	{

		
		register.click();
		return driver;
	}
	public void enterProduct(String ProductText)
	{
		
		searchBox .sendKeys(ProductText);
	}
	
	
	public WebDriver clickSearchButton()
	{
		
		searchClick.click();
		return driver;
	}
	
}
