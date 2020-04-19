package demoqa.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import drivermanager.*;
import drivermanager.DriverManagerFactory;

public abstract class TestBase {
	
	protected WebDriver driver;
	protected String baseUrl;
	protected DriverManager driverManager;
	
	protected TestBase(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	@BeforeMethod
	public void beforeTest() {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		
		long time = 10;
		TimeUnit unit = TimeUnit.SECONDS;
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}
	
	@AfterMethod 
	public void afterTest() {
		driverManager.quitDriver();
	}
}