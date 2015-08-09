package com.appium.facebook.androiduiselector;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class FacebookLoginTest {
	
	@Test
	public void testLoginFB() throws MalformedURLException, InterruptedException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platform-version", "5.0.2");
		capabilities.setCapability("deviceName", "yureka");
		capabilities.setCapability("app", "facebook.apk");
		capabilities.setCapability("appPackage", "com.facebook.katana");
		capabilities.setCapability("appActivity", "LoginActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_username\")").clear();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_username\")").sendKeys("user_name");
		
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_password\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_password\")").sendKeys("password");
		
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_login\").text(\"LOG IN\")").click();
		
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/feed_composer_header\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/status_text\").text(\"What's on your mind?\")").sendKeys("Hello from Appium with UNIX timestamp: " + System.currentTimeMillis());
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/composer_primary_named_button\").description(\"Post\")").click();
		Thread.sleep(4000);
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/header_view_menu_button\").description(\"Story Menu\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/fbui_popover_list_item_title\").text(\"Delete\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/button1\").text(\"Delete\")").click();
		
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/bookmarks_tab\").description(\"More\")").click();
		driver.scrollTo("Log Out").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/button1\").text(\"Log Out\")").click();
		
		/*if(driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/title\").text(\"Contacts Sync\")").isDisplayed()){
			driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/sync_contacts_choice_dont_sync_text\").text(\"Don't sync\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/primary_named_button\").description(\"Done\")").click();
			} */
				
		Thread.sleep(8000);
	}

}
