package homework_page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_objects.SuperPageObject;

public class TablePageObject extends SuperPageObject{
		
		
		public TablePageObject(WebDriver driverInstance, String baseUrl) {
			super(driverInstance, baseUrl);
		}
		
		public TablePageObject navigateTablePage() {
			String url = "/tables";
			navigate(url);
			return this;
		}
		
		public List<WebElement> getTable() {
			return driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
		}

		public String getAmountBasedOffEmail(String email) {
			List<WebElement> tables = getTable();
			for (int i = 0; i < tables.size(); i++) {
				List<WebElement> row = tables.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < row.size(); j++) {
					if (row.get(j).getText().contentEquals(email)) {
						return row.get(j+1).getText();
					}
				}
			}
			return null;
		}
}