package chromeDevTools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
         System.setProperty("webdriver.chrome.driver", "/Users/rahulraman/Desktop/chromedriver");
		
		ChromeDriver driver= new ChromeDriver();//Initiate Chromium Driver
		
		
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width",600);
		deviceMetrics.put("height",1000);
		deviceMetrics.put("deviceScaleFactor",50);
		deviceMetrics.put("mobile",true);
		//here we are not relying on selenium command
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);//there in mobile emulator class we have used send command of webdriver here directly we are using cdp command
driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		//our goal of this code was to mimic the behaviour of browser on phone mode directly with cdp command driver.Execute CdpCommand


	}

}
