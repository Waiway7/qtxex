package homework_page_objects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import page_objects.SuperPageObject;

public class InfiniteScrollPage extends SuperPageObject{
		
		
		public InfiniteScrollPage(WebDriver driverInstance, String baseUrl) {
			super(driverInstance, baseUrl);
		}
		
		public InfiniteScrollPage navigateInfiniteScrollPage() {
			String url = "/infinite_scroll";
			navigate(url);
			return this;
		}
		
		public InfiniteScrollPage scrollDown() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("jscroll-inner")));
			 JavascriptExecutor jse = ((JavascriptExecutor) driver);
			 jse.executeScript("window.scrollTo(0, 800)", "");
	         return this;
		}
		
		public InfiniteScrollPage getGeneratedText() {
			String generatedText = randomizedText().get(length() - 1).getText();
			System.out.println(generatedText);
			return this;
		}
		
		public int length() {
			return randomizedText().size();
		}
		
		public List <WebElement> randomizedText(){
			return driver.findElements(By.className("jscroll-added"));
		}
		
}