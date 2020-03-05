import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTest extends SuperTest{
	

	@Test
	public void canCheckAll() {
	
		List <WebElement> checkBoxes = new CheckPageObject(driver, baseUrl)
											.openCheckPage()
											.canCheckBoxes()
											.getCheckBoxes();
		
		for (WebElement check : checkBoxes) {
			Assert.assertTrue(check.isSelected());
		}
		
	}

	
}