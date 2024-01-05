package Thripura.tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Thripura.pageobjects.Checkoutpage;
import Thripura.pageobjects.ConfirmationPage;
import Thripura.pageobjects.cartpage;
import Thripura.pageobjects.landingpage;
import Thripura.pageobjects.productcatlog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitorderTest
{

	public static void main(String[] args) throws InterruptedException
	
	{

		String productname = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
       //landingpage
       landingpage lp=new landingpage(driver);
        lp.gotourl();
        productcatlog pcl=lp.loginapplication("nandan@gmail.com", "38uday**");
       
       
      List<WebElement>products = pcl.getproductlist();
        pcl.addproducttocart(productname);
        cartpage cp= pcl.gotocart();
        
        //cartpage
        
      Boolean match=cp.verifyproductdisplay(productname);
    
      Assert.assertTrue(match);
      Checkoutpage checkoutpage=cp.gotocheckout();
      checkoutpage.selectcountry("india");
      
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,750)", "");
      
      Thread.sleep(2000);
      
    
      
      ConfirmationPage confirmationpage= checkoutpage.submitorder();
      
      String confirmmessage=confirmationpage.verifyconfirmationmessage();
      
      Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
     
     


         
       
         
	


        		
       
		

	}

}
