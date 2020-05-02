package demoqa.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {
	protected WebDriver driver;
	protected String baseUrl;
	
	public PageBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = "https://demoqa.com/";
		
		PageFactory.initElements(driver, this);
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public void navigate(String url) {
		String pageUrl = new String(baseUrl + url);
		driver.navigate().to(pageUrl);
	}
}