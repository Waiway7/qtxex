package test;
import page_objects.DropDownPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends SuperTest{
	
	@Test
	public void canSelectDropdownListItem() {
		//arrange
		String expectedSelection = new String("Option 2");
		//act
		String actualSelection = new DropDownPageObject(driver, baseUrl)
				.openDropDownPage()
				.setDropDownList(expectedSelection)
				.getDropDownListValue();
		Assert.assertEquals(actualSelection, expectedSelection, "Cannot select a dropdown list value");
	}
	
}

