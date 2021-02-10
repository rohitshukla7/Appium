package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class Calculator extends CalculatorBaseClass {
	
	@Test
	public void addition() throws InterruptedException {
//		driver.findElementById("com.oneplus.calculator:id/digit_2").click();
//		driver.findElementById("com.oneplus.calculator:id/op_add").click();
//		driver.findElementById("com.oneplus.calculator:id/digit_8").click();
//		Thread.sleep(3000);
//		driver.findElementById("com.oneplus.calculator:id/eq").click();
		
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"5\")"))
				.click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 30L)  // L stands for long
		.until(ExpectedConditions.visibilityOfElementLocated(MobileBy
				.AndroidUIAutomator("new UiSelector().resourceId(\"com.oneplus.calculator:id/fun_ln\")")))
		.click();
		driver.findElement(
				By.xpath("//*[@class='android.widget.Button' and @resource-id='com.oneplus.calculator:id/digit_5' and @text='5']"))
				.click();
		driver.findElementById("com.oneplus.calculator:id/digit_5")
		.click();
		
		//Dividing here
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton' and @resource-id='com.oneplus.calculator:id/const_e' and @index='3']")).click();
		//
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"5\")"))
				.click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 30L)  // L stands for long
		.until(ExpectedConditions.visibilityOfElementLocated(MobileBy
				.AndroidUIAutomator("new UiSelector().resourceId(\"com.oneplus.calculator:id/fun_ln\")")))
		.click();
		driver.findElement(
				By.xpath("//*[@class='android.widget.Button' and @resource-id='com.oneplus.calculator:id/digit_5' and @text='5']"))
				.click();
		driver.findElementById("com.oneplus.calculator:id/digit_5")
		.click();
	}
}
