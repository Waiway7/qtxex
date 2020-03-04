import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;

public class SuperTest {
	
	protected WebDriver driver;
	protected String url() {return "http://the-internet.herokuapp.com/";};
  @BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		String directedUrl = url();
		driver.navigate().to(directedUrl);
//		driver = getWebDriver();
	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println("hello world");
	}
	
}