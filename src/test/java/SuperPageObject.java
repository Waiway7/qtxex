import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SuperPageObject {
	protected WebDriver driver; 
	private String baseUrl;
	
	protected SuperPageObject(WebDriver driverInstance, String base) {
		baseUrl = base;
		driver = driverInstance;
		PageFactory.initElements(driver, this);
	}
	
	protected void navigate(String url) {
		driver.get(baseUrl + url);
	}
}
