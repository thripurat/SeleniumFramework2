package Thripura.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractcomponents.abstractcomponents;

public class Checkoutpage extends abstractcomponents 

{
    WebDriver driver;
	public Checkoutpage(WebDriver driver)
{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	By results=By.cssSelector(".ta-results");
	
	//driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123");
    //driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind")
	//driver.findElement(By.cssSelector(".action__submit")).click();
	  //driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	public void placeorder(String name)
	{
		country.sendKeys(name);
	}
	
	public void selectcountry(String countryname)
	{
		  
		Actions a=new Actions(driver);
	         
	  a.sendKeys(country,countryname).build().perform();
	        
	  waitforelementtoappear(results);
	         
	 selectcountry.click();
	}
	
	public ConfirmationPage submitorder()
	{
		submit.click();
	return	new ConfirmationPage(driver);
	}
}
