package homework_page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_objects.SuperPageObject;

public class DownloadPageObject extends SuperPageObject{
		
		
		public DownloadPageObject(WebDriver driverInstance, String baseUrl) {
			super(driverInstance, baseUrl);
		}
		
		public DownloadPageObject navigateTablePage() {
			String url = "/download";
			navigate(url);
			return this;
		}
		
		public DownloadPageObject clickDownloadText() {
			driver.findElement(By.linkText("text.txt")).click();
			return this;
		}
}