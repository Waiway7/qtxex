package homework_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_objects.SuperPageObject;

public class JqueryMenuPage extends SuperPageObject{
		
		
		public JqueryMenuPage(WebDriver driverInstance, String baseUrl) {
			super(driverInstance, baseUrl);
		}
		
		public JqueryMenuPage navigateJqueryMenuPage() {
			String url = "/jqueryui/menu#";
			navigate(url);
			return this;
		}
		
		public JqueryMenuPage clickItemByMenuPath(String [] menu) {
			for (int i = 0, j = 1; i < getNumberOfATags() || j < menu.length; i++) {
				WebElement menuNav = driver.findElements(By.id("ui-id-" + i)).size() != 0 ? driver.findElement(By.id("ui-id-" + i)) : null;
				if (menuNav != null) {
					if (menuNav.getText().contentEquals(menu[j - 1])) {
						menuNav.click();
						j++;
					}
				}
			}
			return this;
		}
		
		public int getNumberOfATags(){
			return driver.findElements(By.xpath("//a[@href]")).size();
		}
		
}