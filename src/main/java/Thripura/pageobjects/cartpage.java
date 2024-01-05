package Thripura.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstractcomponents;

public class cartpage extends abstractcomponents
{

	WebDriver driver;
	
	public cartpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	// List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
	//  boolean match= cartproducts.stream().anyMatch(cart->cart.getText().equals(productname));
	//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	
	
	public  boolean verifyproductdisplay(String productname)
	{
		
		boolean match= cartproducts.stream().anyMatch(cart->cart.getText().equals(productname));
		return match;
	}
	
	public Checkoutpage gotocheckout()
	{
		checkout.click();
		
		 return new Checkoutpage(driver);
		
	}
}