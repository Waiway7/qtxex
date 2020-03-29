package homework;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import homework_page_objects.NestedFrameObject;
import test.SuperTest;

public class NestedFramesTest extends SuperTest {
	@Test
	public void canGetFrameText(){
		
		String expectedLeftFrameText = "LEFT";
		String expectedRightFrameText = "RIGHT";
		String expectedMiddleFrameText = "MIDDLE";
		String expectedBottomFrameText = "BOTTOM";
		
		NestedFrameObject nestedFrame = new NestedFrameObject(driver, baseUrl).openNestedFramePage();
		String actualLeftFrameText = nestedFrame.getLeftFrameText();
		String actualRightFrameText = nestedFrame.getRightFrameText();
		String actualMiddleFrameText = nestedFrame.getMiddleFrameText();
		String actualBottomFrameText = nestedFrame.getBottomFrameText();
		
		Assert.assertEquals(actualLeftFrameText, expectedLeftFrameText, "Left Frame text not displayed");
		Assert.assertEquals(actualRightFrameText, expectedRightFrameText, "Right Frame text not displayed");
		Assert.assertEquals(actualMiddleFrameText, expectedMiddleFrameText, "Middle Frame text not displayed");
		Assert.assertEquals(actualBottomFrameText, expectedBottomFrameText, "Bottom Frame text not displayed");

	}
}