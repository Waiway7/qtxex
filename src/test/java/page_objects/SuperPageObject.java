package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperPageObject {
	protected WebDriver driver; 
	protected WebDriverWait wait;
	private String baseUrl;
	
	protected SuperPageObject(WebDriver driverInstance, String base) {
		baseUrl = base;
		driver = driverInstance;
		wait = new WebDriverWait(driverInstance, 10);
		PageFactory.initElements(driver, this);
	}
	
	protected void navigate(String url) {
		driver.get(baseUrl + url);
	}
	
	public void waitForAttribute(WebElement element, String attribute, String num) {
		wait.until(ExpectedConditions.attributeContains(element, attribute, num));
	}
}
