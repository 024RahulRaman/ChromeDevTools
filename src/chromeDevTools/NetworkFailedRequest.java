package chromeDevTools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.fetch.Fetch;
import org.openqa.selenium.devtools.v99.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v99.network.model.ErrorReason;
public class NetworkFailedRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulraman/Desktop/chromedriver");
        ChromeDriver driver= new ChromeDriver();//Initiate Chromium Driver
		
        DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//java.util.Optional<java.lang.String> urlPattern
		Optional<List<RequestPattern>>	patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
			
			devTools.send(Fetch.enable(patterns, Optional.empty()));
			
			devTools.addListener(Fetch.requestPaused(), request ->
			{
				
				devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
				
			});
			
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
			
			
			
			
			
			
			
			
			
			
			
		}

	}
