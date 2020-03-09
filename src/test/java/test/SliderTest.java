package test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.SliderPageObject;

public class SliderTest extends SuperTest{
	
	@Test
	public void canMoveSlider() {
		WebElement sliderValue = new SliderPageObject(driver, baseUrl)
							.openSliderPage()
							.moveSliderToMaxValue(driver)
							.findSelectSlider();
		String expectedValue = "5";
		Assert.assertEquals(sliderValue.getAttribute("value"), expectedValue, "Incorrect Slider Value");
	}
}