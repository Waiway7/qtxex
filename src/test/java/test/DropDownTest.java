package test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import page_objects.DropDownPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends SuperTest{
	
	@Test
	public void canSelectDropdownListItem() {
		//arrange
		String expectedSelection = "Option 2";
		//act
		String actualSelection = new DropDownPageObject(driver, baseUrl)
				.openDropDownPage()
				.setDropDownList(expectedSelection)
				.getDropDownListValue();
		System.out.println(expectedSelection);
		System.out.println(actualSelection);
		Assert.assertEquals(actualSelection, expectedSelection, "Cannot select a dropdown list value");
	}
	
}

