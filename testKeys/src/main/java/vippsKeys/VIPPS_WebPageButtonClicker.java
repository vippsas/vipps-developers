package vippsKeys;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VIPPS_WebPageButtonClicker {
	static WebDriver driver;
	  
	public static boolean main(String url) throws Exception
	{	
		
		System.setProperty("webdriver.gecko.driver", VIPPS_APIKeys.geckodriverLocation);
		
		System.out.println("WebpagebuttonClicker activated!");
		
		    driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    
		    driver.get(url);
		    
		    if(isElementPresent(By.id("okButton")))
		    {	        
			    driver.findElement(By.id("okButton")).click();
			    System.out.println("clicked!");   
			    Thread.sleep(3000);
		    }
		    else System.out.println("ID: \"okButton\" not found!");
		    driver.quit();
		    return true;
		} 

	
	 private static boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
	
}
