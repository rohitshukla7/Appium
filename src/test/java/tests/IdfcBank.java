package tests;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class IdfcBank {
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 7");
		caps.setCapability(MobileCapabilityType.UDID, "a1a1a489");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability("appPackage", "com.idfcbank.mobileBanking");
		caps.setCapability("appActivity", "com.idfcbank.mobileBanking.login.SplashNew");
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url, caps);
	}
	
	
	@Test(priority=1)
	public void getBalance() throws InterruptedException {
		
		new WebDriverWait(driver, 30L)
		.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("com.idfcbank.mobileBanking:id/balance_txt")));
		
		
		String bal;
		bal = driver.findElementById("com.idfcbank.mobileBanking:id/balance_txt").getText();
		//int balance = Integer.parseInt(bal);
		System.out.println("Available balance:"+bal);
		Thread.sleep(3000);
		//logout();
		
	}
	
	
	@Test(priority=2, enabled=true)
	public void myProfile() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton' and @index='0']"))
		.click();
		
		Assert.assertTrue(isFundTransferPresent(),"Fund Transfer is not present");
	
		
		MobileElement listitem = (MobileElement) driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
						+ "new UiSelector().text(\"MY PROFILE\"));"));
		
		listitem.click();
		
		//driver.findElementsById("com.idfcbank.mobileBanking:id/listTitle").get(2).click();  //for my accounts
		
		String prof = driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='My Profile']")).getText();
		System.out.println("Landed on My Profile page:"+prof);
		
		//driver.pressKeyCode(AndroidKeyCode.BACK); // doubt in use case
		//driver.navigate().back();  //works
		Thread.sleep(2000);
		logout();
	}
	
	private boolean isFundTransferPresent() {
		String fundTransfer;
		fundTransfer = driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='FUNDS TRANSFER']")).getText();
		Assert.assertEquals(fundTransfer, "FUNDS TRANSFER"); //java.lang.AssertionError: expected [FUND TRANSFER] but found [FUNDS TRANSFER]
		return true;
	}


	private void logout() {
		
		new WebDriverWait(driver, 30L)
		.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("com.idfcbank.mobileBanking:id/action_versionName")))
		.click();
		
		//driver.findElementById("com.idfcbank.mobileBanking:id/action_versionName").click();
		driver.findElement(By.id("android:id/button1")).click();
		
	}

	@Test(priority=0)
	public void login() {
		
		new WebDriverWait(driver, 30L)
		.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("com.android.permissioncontroller:id/permission_allow_button")))
		.click();
		
		//driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
		driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
		
		driver.findElementById("com.idfcbank.mobileBanking:id/editUsername").sendKeys("rohits95");
		driver.findElementById("com.idfcbank.mobileBanking:id/editPassword").sendKeys("Mohit@2016");
		driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}
