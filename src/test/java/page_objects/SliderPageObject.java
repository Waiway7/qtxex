package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderPageObject extends SuperPageObject {
	public SliderPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	public SliderPageObject openSliderPage() {
		String url = "/horizontal_slider";
		navigate(url);
		return this;
	}
	
	public WebElement findSelectSlider() {
		return driver.findElement(By.cssSelector("input"));
	}
	
	public SliderPageObject moveSliderToMaxValue(WebDriver driver) {
		Actions move = new Actions(driver);
		WebElement slider = findSelectSlider();
		Action action = (Action) move.dragAndDropBy(slider, slider.getSize().width, 0).build();
		action.perform();
		return this;
	}
}