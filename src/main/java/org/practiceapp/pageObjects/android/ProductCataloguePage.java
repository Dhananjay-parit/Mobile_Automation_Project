package org.practiceapp.pageObjects.android;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class ProductCataloguePage extends AndroidActions {
	AndroidDriver driver;
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> products;
	//List<WebElement> products1 = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	public ProductCataloguePage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void addItemToCartByIndex(int index) 
	{
		products.get(index).click();
		
	}
	
	public CartPage goToCart() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);

	}

}
