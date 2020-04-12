package seven_page_objects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_objects.SuperPageObject;

public class BrokenImagesPageObject extends SuperPageObject{
	
	public BrokenImagesPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public BrokenImagesPageObject openBrokenImagesPage() {
		String url = "/broken_images";
		navigate(url);
		return this;
	}
	
	public List<WebElement> getImgs() {
		return driver.findElements(By.tagName("img"));
	}
	
	public Boolean checkForBrokenImages() {
		List<WebElement> images = getImgs();
		for (int i = 0; i < images.size(); i++){
			if (images.get(i).getAttribute("naturalWidth").equals("0")) {
				return true;
			}
		}
	    return false;
	}
	
}