package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPageObject extends SuperPageObject {
	
	public DropDownPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public DropDownPageObject openDropDownPage() {
		String url = "/dropdown";
		navigate(url);
		return this;
	}
	
	public DropDownPageObject setDropDownList(String value) {
		getDropDown().selectByVisibleText(value);
		return this;
	}
	
	public String getDropDownListValue() {
		return getDropDown().getFirstSelectedOption().getText();
	}
	
	public Select getDropDown() {
		return new Select(driver.findElement(By.id("dropdown")));
	}
	
}