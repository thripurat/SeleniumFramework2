package Thripura.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class test1


{
	 WebDriver driver;
	
	public test1(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement username;
   // driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("nandan@gmail.com");
    
	@FindBy(css="input[type='password']")
	WebElement password;
	
    //driver.findElement(By.cssSelector("input[type='password']")).sendKeys("38uday**");
	
	@FindBy(id="login")
	WebElement submit;
	
	public void loginapplication(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
	}
	
	//this is the new update done to test
    //driver.findElement(By.id("login")).click();
}
