package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputPageObject extends SuperPageObject {
	
	public InputPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public InputPageObject openInputPage() {
		String url = "/inputs";
		navigate(url);
		return this;
	}
	
	public WebElement getInputField() {
		return driver.findElement(By.cssSelector("input"));
	}
	
	public InputPageObject setInputValue(int num) {
		getInputField().sendKeys(String.valueOf(num));
		return this;
	}
	
	public String getInputValue() {
		return getInputField().getAttribute("value");
	}
	
	public InputPageObject waitForValue() {
		waitForAttribute(getInputField(), "value", getInputValue());
		return this;
	}
	
}