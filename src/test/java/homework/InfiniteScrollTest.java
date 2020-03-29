package homework;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import homework_page_objects.InfiniteScrollPage;
import test.SuperTest;

public class InfiniteScrollTest extends SuperTest {
	@Test
	public void testingUpdatedText(){
		int expectedPara = 3;
		int actualPara = new InfiniteScrollPage(driver, baseUrl)
										.navigateInfiniteScrollPage()
										.scrollDown()
										.getGeneratedText()
										.length();	
		Assert.assertEquals(actualPara, expectedPara, "Scroll did not work!");
	}
}