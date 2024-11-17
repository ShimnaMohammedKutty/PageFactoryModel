package pfpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PfLoginPage {
	
WebDriver driver;
	
	public PfLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	WebElement emailEnter;
	
	@FindBy(id="input-password")
	WebElement passwordEnter ;
	
	@FindBy(xpath="//input[@value='Login']")
    WebElement loginclick ;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement warningMessage;
	
	

	
	public void enterEmailField(String email)
	{
	
	emailEnter.sendKeys(email);
	
	}
	
	public void enterPasswordField(String password)
	{
		
	passwordEnter.sendKeys(password);
	}
	
	public WebDriver clickOnLoginButton()
	{
		loginclick.click();
		return driver;
		
	}

	public String invalidMessage()
	{
		
		return warningMessage.getText();
	}
	


}
