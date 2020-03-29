
package homework;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import homework_page_objects.HoverPageObject;
import test.SuperTest;

public class HoverTest extends SuperTest {
	@Test
	public void hoverProfileAndClickLink(){
		String expectedUrl = "http://the-internet.herokuapp.com/users/3";
		String actualUrl = new HoverPageObject(driver, baseUrl)
								.navigateHoverPage()
								.clickUserLink()
								.getUrl();
		Assert.assertEquals(expectedUrl, actualUrl, "Wrong url");
	}
}