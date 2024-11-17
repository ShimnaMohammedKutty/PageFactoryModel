package pfpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PfSearchPage {
	
WebDriver driver;
	
	public PfSearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="HP LP3065")
	WebElement existingProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	WebElement product;
	
	
	public boolean validProductIsDisplayed()
	{
	
		return existingProduct.isDisplayed();
	}
	public String invalidProductMessage()
	{
		
	    return product.getText();
	
	}

}
