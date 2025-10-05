package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		
		this.driver = driver;
	}

	public void longPress(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	
	public void scrollToEndAction() {
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "Down",
			    "percent", 3.0
			));
	}
	
	public void ScrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ text +"\"));"));
	}
	
	public void swipeAction(WebElement ele, String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
				"direction", direction,
				"percent", 0.75
				));
	}
	
	public void DragAndDrop(WebElement source)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 807,
			    "endY", 729
			));
		Assert.assertEquals(driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");
	
	}

}
