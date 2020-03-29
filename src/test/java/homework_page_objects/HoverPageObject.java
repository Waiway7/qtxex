package homework_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import page_objects.SuperPageObject;

public class HoverPageObject extends SuperPageObject{
		
		
		public HoverPageObject(WebDriver driverInstance, String baseUrl) {
			super(driverInstance, baseUrl);
		}
		
		public HoverPageObject navigateHoverPage() {
			String url = "/hovers";
			navigate(url);
			return this;
		}
		
		public WebElement hoverUserThree() {
			
			return driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));

		}
		
		public HoverPageObject clickUserLink() {
			Actions action = new Actions(driver);
			action.moveToElement(hoverUserThree())
					.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/a")))
					.click().build().perform();
			return this;
		}
		
		public String getUrl() {
			return driver.getCurrentUrl();
		}

		
}