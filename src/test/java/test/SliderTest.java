package test;
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
		Assert.assertEquals(actualSliderValue, expectedValue, "Incorrect Slider Value");
	}
}