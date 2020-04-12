package seven_test;

import test.SuperTest;
import seven_page_objects.DynamicLoadingPageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends SuperTest{
	
	@Test
	public void testHiddenElement() throws InterruptedException {
		
		String expectedText = "Hello World!";
		String actualText = new DynamicLoadingPageObject(driver, baseUrl)
								.openDynamicLoadingPage()
								.clickButton()
								.getLoadedText();
		Assert.assertEquals(actualText, expectedText, "Hidden Element did not load!");
	}
	
}