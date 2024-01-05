package Thripura.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstractcomponents;

public class ConfirmationPage extends abstractcomponents 

{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// String confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css=".hero-primary")
	WebElement confirmationmsg;
	
	

	public String verifyconfirmationmessage() 
	{
		return confirmationmsg.getText();
	}
	
}
