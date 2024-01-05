package Thripura.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstractcomponents;

public class landingpage extends abstractcomponents

{
	WebDriver driver;
	
	
	public landingpage(WebDriver driver) 
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement useremail1= driver.findElement(By.xpath("//input[@id='userEmail']"));
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement useremail;
	
	// driver.findElement(By.cssSelector("input[type='password']")).sendKeys("38uday**");
	
	@FindBy(css="input[type='password']")
	WebElement userpassword;
	
	// driver.findElement(By.id("login")).click();
	
	@FindBy(id="login")
	WebElement submit;
	
	public productcatlog loginapplication(String email,String pwd)
	{
		useremail.sendKeys(email);
		userpassword.sendKeys(pwd);
		submit.click();
		
       productcatlog pcl=new productcatlog(driver);
           return pcl;
	}
	
	public void gotourl() 
	{
		 driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
