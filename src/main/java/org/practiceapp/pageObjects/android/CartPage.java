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

public class CartPage extends AndroidActions {
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> displayPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement displayedTotalAmount;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement tearms;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	
	public void acceptTearmsConditions()
	{
		longPress(tearms);
		acceptButton.click();
	}
	
	public double getProductSum()
	{
		double amount=0;
		for(int i=0; i<displayPrices.size(); i++)
		{
			String price = displayPrices.get(i).getText();
			double formattedPrice = getFormattedAmount(price);
			amount = amount + formattedPrice;
		}
		return amount;
	}
	
	public double getTotalAmountDisplayed()
	{
		return getFormattedAmount(displayedTotalAmount.getText());
		
	}
	
	
	
	public void submitOrder()
	{
		checkBox.click();
		proceedButton.click();
	}
}
