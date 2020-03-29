package homework_page_objects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page_objects.SuperPageObject;

public class WindowsPageObject extends SuperPageObject{
		
		private ArrayList<String> tabs;
		public WindowsPageObject(WebDriver driverInstance, String baseUrl) {
			super(driverInstance, baseUrl);
		}
		
		public WindowsPageObject navigateWindowsPage() {
			String url = "/windows";
			navigate(url);
			return this;
		}
		
		public WindowsPageObject clickHere() {
			driver.findElement(By.linkText("Click Here")).click();
			return this;
		}
		
		public WindowsPageObject switchToNextTab(){
			tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			return this;
		}
		
		public String getTextFromNextTab() {
			return driver.findElement(By.tagName("h3")).getText();
		}
		
		public WindowsPageObject closeAndSwitchBackToTab() {
			driver.close();
			driver.switchTo().window(tabs.get(0));
			return this;
		}
		
}