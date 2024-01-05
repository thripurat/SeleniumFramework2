package Testcomponents1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{

	public WebDriver driver;
	public void initializedriver() throws IOException
	{
		
		
		
		Properties prop=new Properties();	
   FileInputStream fis=new FileInputStream
   (System.getProperty("user.dir")+"\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
	        driver.manage().window().maximize();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
				{
	              //firefox
				}
		
		else if(browsername.equalsIgnoreCase("Edge"))
		{
          //EdgeDriver
		}
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
}
