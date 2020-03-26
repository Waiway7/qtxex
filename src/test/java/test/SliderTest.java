package test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.SliderPageObject;

public class SliderTest extends SuperTest{
	
	@Test
	public void canMoveSlider() {
		String actualSliderValue = new SliderPageObject(driver, baseUrl)
									.openSliderPage()
									.moveSliderToMaxValue(driver)
									.findSliderValue();
		String expectedValue = "5";
		AssertJUnit.assertEquals(actualSliderValue, expectedValue, "Incorrect Slider Value");
	}
}