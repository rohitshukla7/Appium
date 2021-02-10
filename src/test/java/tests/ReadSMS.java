package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ReadSMS {
static AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi A2");
		caps.setCapability(MobileCapabilityType.UDID, "461bae6e");  //a1a1a489
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability("appPackage", "com.google.android.apps.messaging"); //com.oneplus.mms
		caps.setCapability("appActivity", "com.google.android.apps.messaging.home.HomeActivity");  //com.android.mms.ui.TestActivity

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		
		
		driver = new AppiumDriver<MobileElement>(url, caps);
	}
	
	@Test
	public void readSMS() {
		new WebDriverWait(driver, 60L)
		.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@class='android.widget.TextView' and @text='Rohit']"))).click();
		
		
		//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='Rohit']")).click(); 
		String ot=123456
				
				
		
		String str = driver.findElementByXPath("//*[@class='android.widget.TextView' and @text=ot+'is your OTP for login.']").getText();
		//String str = driver.findElementById("com.google.android.apps.messaging:id/message_text_and_info").getText();
		
		System.out.println(str);
		
		String otp = str.replaceAll("[^0-9]", "");
		
		//System.out.println("String:"+str.toString());
		System.out.println("OTP:"+otp);
		
	}
	
	

}
