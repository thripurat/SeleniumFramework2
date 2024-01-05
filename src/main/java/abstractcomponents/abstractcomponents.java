package abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Thripura.pageobjects.cartpage;

public class abstractcomponents 

{
     WebDriver driver;
	public abstractcomponents(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartheader;
	
	public void waitforelementtoappear(By findBy)
	{
       WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
       w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitforelementtodisappear(WebElement ele)
	{
		
		
		  WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));  
	}
	
	public cartpage gotocart()
	{
		cartheader.click();
		cartpage cp=new cartpage(driver);
		return cp;
	}
	
}
