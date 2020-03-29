package homework_page_objects;

import page_objects.SuperPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSAlertPage extends SuperPageObject{
	public JSAlertPage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public JSAlertPage navigateJSAlertPage() {
		String url = "/javascript_alerts";
		navigate(url);
		return this;
	}
	
	public JSAlertPage clickButton(String text) {
		if (text == "JS Alert") {
			getAlertButton().click();
		}
		else if (text == "JS Confirm") {
			getConfirmButton().click();
		}
		else if (text == "JS Prompt") {
			getPromptButton().click();
		}
		return this;
	}
	
	public JSAlertPage acceptAlertMessage() {
		driver.switchTo().alert().accept();
		return this;
	}
	
	public JSAlertPage acceptConfirmMessage() {
		driver.switchTo().alert().accept();
		return this;
	}
	
	public JSAlertPage sendPrompt(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
		return this;
	}
	
	public String getActualText() {
		return driver.findElement(By.id("result")).getText();
	}
	
	public WebElement getAlertButton() {
		return driver.findElements(By.tagName("button")).get(0);
	}
	
	public WebElement getConfirmButton() {
		return driver.findElements(By.tagName("button")).get(1);
	}
	
	public WebElement getPromptButton() {
		return driver.findElements(By.tagName("button")).get(2);
	}
}