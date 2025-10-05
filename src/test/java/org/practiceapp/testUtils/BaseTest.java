package org.practiceapp.testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.practiceapp.pageObjects.android.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.AppiumUtils;

public class BaseTest extends AppiumUtils{

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public FormPage formPage;
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, IOException {
				
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\practiceapp\\resources\\data.properties");
				prop.load(fis);
				String ipAddress = prop.getProperty("ipAddress");
				String port = prop.getProperty("port");
				service = startAppiumServer(ipAddress, Integer.parseInt(port));
				service.start();
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName(prop.getProperty("AndroidDeviceName"));
				options.setChromedriverExecutable("G:\\My Resume\\chromedriver.exe");
				options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\org\\practiceapp\\resources\\General-Store.apk");
				driver = new AndroidDriver(service.getUrl(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				formPage = new FormPage(driver);
	}
	
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
