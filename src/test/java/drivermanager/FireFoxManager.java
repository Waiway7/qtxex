package drivermanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends DriverManager{
	@Override
	protected void startService() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub
	}

	@Override
	public void createDriver() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/ugp/Downloads/geckodriver");
//		 System.setProperty("webdriver.gecko.driver","D://Selenium Training//Selenium Environment Files//geckodriver.exe"); 
		 
        driver = new FirefoxDriver();
        long time = 1000;
		TimeUnit unit = TimeUnit.MILLISECONDS;
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}
}
