package seven_page_objects;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import page_objects.SuperPageObject;

public class SecureUploadPageObject extends SuperPageObject{
	
	public SecureUploadPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public WebElement getUploadedDiv() {
		return driver.findElement(By.id("uploaded-files"));
	}
	
	public Boolean checkForElement() {
		WebElement uploadTextBox = getUploadedDiv();
		return uploadTextBox.getText().contains("QualityAssuranceTest.txt");
	}
	
	public String getUploadedFileName() {
		if (waitForDiv()) {
			return getUploadedDiv().getText();
		}
		return null;
	}
	
	private Boolean waitForDiv() {
		return new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofMillis(6000))
		        .pollingEvery(Duration.ofMillis(1000))
		        .until(new Function<WebDriver, Boolean>() {
		        	public Boolean apply(WebDriver driver) {
		                return checkForElement();
		              }
		        });
	}
}