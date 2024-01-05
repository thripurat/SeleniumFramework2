package Thripura.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.abstractcomponents;

public class productcatlog extends abstractcomponents

{
	WebDriver driver;
	
	
	public productcatlog(WebDriver driver) 
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElements(By.cssSelector(".col-lg-4" ));
	@FindBy(css=".col-lg-4")
	List<WebElement>products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	 By  productsby=By.cssSelector(".col-lg-4" );
	 By addtocart=By.cssSelector(".card-body button:last-of-type");
	 By toast=By.cssSelector("#toast-container");
	
	public List<WebElement> getproductlist()
	{
		
		waitforelementtoappear(productsby);
		return products;
	}
	
	public WebElement getproductname(String productname)
	{

     WebElement prod = getproductlist().stream().filter(product->
     product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
     return prod;
	}
	
	public void addproducttocart(String productname)
	{
		  WebElement prod=getproductname(productname);
		
         prod.findElement(addtocart).click();
         waitforelementtoappear(toast);
         waitforelementtodisappear(spinner);
		
		
		
	}
	
}
