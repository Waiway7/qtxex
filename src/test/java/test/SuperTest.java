package test;
import drivermanager.DriverManagerFactory;
import drivermanager.DriverType;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;

public abstract class SuperTest {
	
	protected WebDriver driver;
	protected String baseUrl;
	
	@BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		baseUrl = "http://the-internet.herokuapp.com/";
//		driver = getWebDriver();
	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}