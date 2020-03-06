package page_objects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckPageObject extends SuperPageObject{
	public CheckPageObject(WebDriver driverInstance, String baseUrl){
			super(driverInstance, baseUrl);
	}
	
	public List<WebElement> getCheckBoxes() {
		return driver.findElements(By.cssSelector("input[type=checkbox]"));
	}
	
	public CheckPageObject canCheckBoxes() {
		for(WebElement box : getCheckBoxes()) {
			if (!box.isSelected()) {
				box.click();	
			}
		}
		return this;
	}
	
	public CheckPageObject openCheckPage() {
		String url = "/checkboxes";
		navigate(url);
		return this;
	}
	
}