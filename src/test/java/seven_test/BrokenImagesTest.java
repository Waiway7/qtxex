package seven_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.SuperTest;
import seven_page_objects.BrokenImagesPageObject;


public class BrokenImagesTest extends SuperTest {
	
	@Test
	public void checkBrokenImages() {
		Boolean brokenImages = new BrokenImagesPageObject(driver, baseUrl)
									.openBrokenImagesPage()
									.checkForBrokenImages();
		Assert.assertTrue(brokenImages, "No broken images found!");
	}
}