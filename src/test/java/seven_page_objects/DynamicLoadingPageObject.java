package seven_page_objects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import page_objects.SuperPageObject;

public class DynamicLoadingPageObject extends SuperPageObject{
	
	public DynamicLoadingPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, "http://admin:admin@the-internet.herokuapp.com");
	}
	

	public DynamicLoadingPageObject openDynamicLoadingPage() {
		String url = "/dynamic_loading/1";
		navigate(url);
		return this;
	}
	
	public String getLoadedText() throws InterruptedException {
		if (waitForElementToLoad()) {
			return getHiddenEle().getText();	
		}
		return null;
	}
	
	public DynamicLoadingPageObject clickButton() {
		getButton().click();
		return this;
	}
	
	private Boolean checkHiddenEle() {
		WebElement hiddenEle = getHiddenEle();		
		return !hiddenEle.getCssValue("display").contains("none");
	}
	
	private Boolean waitForElementToLoad() {
		getHiddenEle().getCssValue("display");
		return new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofMillis(6000))
		        .pollingEvery(Duration.ofMillis(1000))
		        .until(new Function<WebDriver, Boolean>() {
		        	public Boolean apply(WebDriver driver) {
		                return checkHiddenEle();
		              }
		        });
	}
	
	private WebElement getButton() {
		return driver.findElement(By.xpath("//*[@id='start']/button"));
	}
	
	private WebElement getHiddenEle() {
		return driver.findElement(By.xpath("//*[@id=\"finish\"]"));
	}
}