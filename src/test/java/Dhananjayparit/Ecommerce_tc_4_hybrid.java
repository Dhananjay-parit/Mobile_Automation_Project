package Dhananjayparit;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.practiceapp.pageObjects.android.CartPage;
import org.practiceapp.pageObjects.android.FormPage;
import org.practiceapp.pageObjects.android.ProductCataloguePage;
import org.practiceapp.testUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce_tc_4_hybrid extends BaseTest {
	
	@Test(dataProvider="getData", groups= {"Smoke"})
	public void chromeNavigation(HashMap<String,String> input) throws InterruptedException {
		
		Thread.sleep(2000);
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.selectCountry(input.get("country"));
		ProductCataloguePage productCateloguePage = formPage.submitForm();
		productCateloguePage.addItemToCartByIndex(0);
		productCateloguePage.addItemToCartByIndex(1);
		CartPage cartPage = productCateloguePage.goToCart();

		double amount = cartPage.getProductSum();
		double totalAmount = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(amount, totalAmount);
		cartPage.acceptTearmsConditions();
		cartPage.submitOrder();
			
		
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\practiceapp\\testData\\eCommerce.json");
		return new Object[][] {{data.get(0) }};
		//return new Object[][] {{"Dhananjay Parit", "Male", "Argentina" }};
		
	}
}
