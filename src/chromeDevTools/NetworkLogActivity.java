package chromeDevTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.network.Network;
import org.openqa.selenium.devtools.v99.network.model.Request;
import org.openqa.selenium.devtools.v99.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "/Users/rahulraman/Desktop/chromedriver");
        ChromeDriver driver= new ChromeDriver();//Initiate Chromium Driver
		
        //log file-->
        
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(),request->
		{
			
			Request req=request.getRequest();
			System.out.println(req.getUrl());
			
			
			
			
		});
		
		
		
		
		
		
		//event will get fired
		devTools.addListener(Network.responseReceived(), response ->//Lambda expression
		{
		Response res = response.getResponse();
		//System.out.println(res.getUrl());
		response.getResponse().getStatus();		
		}	);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("[data-target*='Modal']")).click();
	}

}
