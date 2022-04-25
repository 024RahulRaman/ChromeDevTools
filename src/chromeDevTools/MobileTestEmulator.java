package chromeDevTools;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
public class MobileTestEmulator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/rahulraman/Desktop/chromedriver");
		
		ChromeDriver driver= new ChromeDriver();//Initiate Chromium Driver
		
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		
		//Selenium send commands to CDP methods--> CDP methods will invoke and get access to chrome dev tools
		//CDP method will execute on chrome dev tools and chrome dev tools immediately change your screen dimensions.From selenium we will now kick the CDP methods and this cdp methods will go through the chrome dev tools and will do work for us
		
		
		
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	
         driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		driver.close();
		//Network.getRequestPostData 
	
	////our goal of this code was to mimic the behaviour of browser on phone mode with the help of devTools send command reger the note at page 79
	
	}

}
