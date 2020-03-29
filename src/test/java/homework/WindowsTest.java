package homework;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import homework_page_objects.WindowsPageObject;
import test.SuperTest;

public class WindowsTest extends SuperTest {
	@Test
	public void getContentFromNewTab(){
		String expectedText = "New Window";
		WindowsPageObject window = new WindowsPageObject(driver, baseUrl)
								.navigateWindowsPage()
								.clickHere()
								.switchToNextTab();
								
		
		String actualText = window.getTextFromNextTab();
		
		window.closeAndSwitchBackToTab();
		
		Assert.assertEquals(expectedText, actualText, "No text find in new tab!");
	}
}