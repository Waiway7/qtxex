package seven_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import page_objects.SuperPageObject;
import org.openqa.selenium.WebElement;

public class IFramePageObject extends SuperPageObject {
	public IFramePageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	public IFramePageObject openIFramePage() {
		String url = "/tinymce";
		navigate(url);
		return this;
	}
	
	public IFramePageObject switchToFrame() {
		switchToDefault();
		driver.switchTo().frame("mce_0_ifr");
		return this;
	}
	
	public WebElement getParagraph() {
		return driver.findElement(By.xpath("//body[@id='tinymce']//p"));
	}
	
	public IFramePageObject switchToDefault() {
		driver.switchTo().defaultContent();
		return this;
	}
	
	public IFramePageObject deleteText() {
		WebElement pTag = getParagraph();
		int length = pTag.getText().length();
		
		for (int i = 0; length > i; i++) {
			pTag.sendKeys(Keys.BACK_SPACE);
		}
		
		return this;
	}
	
	public final Boolean textDeleted() {
		return getParagraph().getText().length() == 0;
	}
	
	public IFramePageObject typeText() {
		WebElement pTag = getParagraph(); 
		pTag.sendKeys("QA testing here to save the day!");
		return this;
	}
	
	public String getText() {
		return getParagraph().getText();
	}
}