package seven_test;
import seven_page_objects.IFramePageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import test.SuperTest;

public class IFrameTest extends SuperTest{
	@Test
	public void canWriteInIFrame() {
		String expectedText = "QA testing here to save the day!";
		String actualText = new IFramePageObject(driver, baseUrl)
							.openIFramePage()
							.switchToFrame()
							.deleteText()
							.typeText()
							.getText();
		Assert.assertEquals(actualText, expectedText, "Unidentified text due to Iframe!");
	}
}