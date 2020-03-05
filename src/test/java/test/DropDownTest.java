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


//@Override
//protected String url() {
//	return "http://the-internet.herokuapp.com/dropdown";
//}

//@Test
//public void canNavigateToDropDown() {
//	//arrange
//	String expectedHeader = new String("Dropdown List");
//	
//	//act
//	WebElement dropDownLink = driver.findElement(
//			By.xpath("//*[text()[contains(.,'Dropdown')]]"));
//	dropDownLink.click();
//	
//	//assert
//	WebElement header = driver.findElement(By.tagName("h3"));
//	Assert.assertEquals(header.getText(), expectedHeader, "Wrong webpage!");
//}