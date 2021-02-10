package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorBaseClass {
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 7");
		caps.setCapability(MobileCapabilityType.UDID, "a1a1a489");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability("appPackage", "com.oneplus.calculator");
		caps.setCapability("appActivity", "com.oneplus.calculator.Calculator");
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url, caps);
	}	
}
