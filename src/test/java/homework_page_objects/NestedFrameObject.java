package homework_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page_objects.SuperPageObject;

public class NestedFrameObject extends SuperPageObject{
	public NestedFrameObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public NestedFrameObject openNestedFramePage() {
		String url = "/nested_frames";
		navigate(url);
		return this;
	}
	
	public String getLeftFrameText() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		return driver.findElement(By.tagName("body")).getText();
	}
	
	public String getMiddleFrameText() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		return driver.findElement(By.tagName("div")).getText();
	}
	
	public String getRightFrameText() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		return driver.findElement(By.tagName("body")).getText();
	}
	
	public String getBottomFrameText() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		return driver.findElement(By.tagName("body")).getText();
	}
	
}