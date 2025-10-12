package Dhananjayparit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.practiceapp.testUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ecommerce_tc_1 extends BaseTest {
	
	//@BeforeMethod
	public void PreSetup() 
	{
		
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
		
	}
	
	
	@Test
	public void fillFormErrorValidation() throws InterruptedException {
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dhanajay Parit");
		driver.hideKeyboard();
		formPage.setGender("male");
		formPage.selectCountry("Argentina");
		formPage.submitForm();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
				
		
	}
	
	@Test
	public void fillFormPositive() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dhanajay Parit");
		driver.hideKeyboard();
		formPage.setGender("male");
		formPage.selectCountry("Argentina");
		formPage.submitForm();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
		//Assert.assertEquals(toastMessage, "Please enter your name");
		
				
		
	}

	

}
