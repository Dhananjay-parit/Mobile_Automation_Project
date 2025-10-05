package org.practiceapp.pageObjects.android;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions {
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	WebElement namefield;
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dhanajay Parit");
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	WebElement femaleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	WebElement maleOption;
	
	@AndroidFindBy(id="android:id/text1")
	WebElement countryList;
//	driver.findElement(By.id("android:id/text1")).click();
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	WebElement ShopButton;
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	public void setNameField(String name)
	{
		namefield.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender=="Male")
			maleOption.click();
		else
			femaleOption.click();
		
	}
	
	public void selectCountry(String text)
	{
		countryList.click();
		ScrollToText(text);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']")).click();
	}
	
	public ProductCataloguePage submitForm()
	{
		ShopButton.click();
		return new ProductCataloguePage(driver);
	
	}

}
