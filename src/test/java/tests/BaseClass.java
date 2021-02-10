package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() {
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			
//			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
//			caps.setCapability(CapabilityType.VERSION,"10" );
//			caps.setCapability("deviceName", "OnePlus 7");
//			caps.setCapability(CapabilityType.ud, "a1a1a489");
//			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60 );
//			caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome" );
			
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0" );
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 7");
			caps.setCapability(MobileCapabilityType.UDID, "192.168.1.100:5555");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60 );
			caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome" );
			//caps.setCapability(MobileCapabilityType.APP, );
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new AppiumDriver<MobileElement>(url, caps);
			
		} catch (Exception e) {
			System.out.println("Cause is:"+e.getCause());
			System.out.println("Message is: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
