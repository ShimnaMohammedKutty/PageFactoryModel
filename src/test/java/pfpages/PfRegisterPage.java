package pfpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PfRegisterPage {
	

	WebDriver driver;
	
	public PfRegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id='input-firstname']/following-sibling::div")
	WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//*[@id='input-lastname']/following-sibling::div")
	WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//*[@id='input-email']/following-sibling::div")
	WebElement emailWarningMessage;
	
	@FindBy(xpath="//*[@id='input-telephone']/following-sibling::div")
	 WebElement phoneWarningMessage;
	
	@FindBy(xpath="//*[@id='input-password']/following-sibling::div")
	 WebElement passwordWarningMessage;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	 WebElement privacyWarningMessage;
	
	
	@FindBy(id="input-firstname")
	 WebElement firstName ;
	 
	
	@FindBy(id="input-lastname")
	 WebElement lastName;
	
	@FindBy(id="input-email")
		WebElement emailField ;
	
	@FindBy(id="input-telephone")
		WebElement phone ;
	
	@FindBy(id="input-password")
		WebElement passwordField ;
	
	@FindBy(id="input-confirm")
		WebElement confirmPasswordField ;
	
	@FindBy(name="agree")
		WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
		WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
		WebElement newsLetter;
		
		
	    
    public String getFirstNameWarningMessage()
    {
    	
    	return firstNameWarningMessage.getText();
    }
	
    public String getlastNameWarningMessage()
    {
    	
    	return lastNameWarningMessage.getText();
    }
	
    public String getEmailWarningMessage()
    {

    	return  emailWarningMessage.getText();
    }
	
    public String getPhoneWarningMessage()
    {
    	 
    	return phoneWarningMessage.getText();
    }
	
    public String getPasswordWarningMessage()
    {
    	
    	return passwordWarningMessage.getText();
    }
    public String getPrivacyWarningMessage()
    {
    	
    	return privacyWarningMessage.getText();
    }
	
	
    
	public void enterFirstName(String firstNameData)
	{
		
		firstName.sendKeys(firstNameData);
	}
	public void enterLastName(String lastNameData)
	{
		
		lastName.sendKeys(lastNameData);
	}
	public void enterEmailFeld(String email)
	{
	
		emailField.sendKeys(email);
	}
	public void enterPhoneFeld(String telephone)
	{
		
		 phone.sendKeys("telephone");
	}
	public void enterPassword(String password)
	{
	
		
		passwordField.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		
		confirmPasswordField .sendKeys(confirmPassword);
	}
	public void clickPrivacyPolicy()
	{
		
		privacyPolicy .click();
	}
	public void clickContinue()
	{
		
		 continueButton.click();
	}
	public void newsLetterOption()
	{
		
	
		newsLetter.click();
	}

}
