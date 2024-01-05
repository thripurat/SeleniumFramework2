package Thripura.tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Thripura.pageobjects.landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone
{

	public static void main(String[] args) throws InterruptedException
	
	{

		String productname = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
       driver.get("https://rahulshettyacademy.com/client/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       landingpage lp=new landingpage(driver);
       
       driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("nandan@gmail.com");
       
       
       driver.findElement(By.cssSelector("input[type='password']")).sendKeys("38uday**");
       driver.findElement(By.id("login")).click();
       
       
       WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
       w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
       
       List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4" ));
       
       WebElement prod = products.stream().filter(product->
       product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
       
       prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
       
      
       w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
       
       w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
       
       driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
       
         List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
         
         boolean match= cartproducts.stream().anyMatch(cart->cart.getText().equals(productname));
         Assert.assertTrue(match);
         
         driver.findElement(By.xpath("//button[text()='Checkout']")).click();
         
         driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123");
        // driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
         
         Actions a=new Actions(driver);
         a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
         w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
         

         driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
         
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,250)", "");
         
         driver.findElement(By.cssSelector(".action__submit")).click();
      String confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
      
     Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


         
       
         
	


        		
       
		

	}

}
