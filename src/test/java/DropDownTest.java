import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DropDownTest extends SuperTest{
	
//	@Override
//	protected String url() {
//		return "http://the-internet.herokuapp.com/dropdown";
//	}
	
	@Test
	public void canNavigateToDropDown() {
		//arrange
		String expectedHeader = new String("Dropdown List");
		
		//act
		WebElement dropDownLink = driver.findElement(
				By.xpath("//*[text()[contains(.,'Dropdown')]]"));
		dropDownLink.click();
		
		//assert
		WebElement header = driver.findElement(By.tagName("h3"));
		Assert.assertEquals(header.getText(), expectedHeader, "Wrong webpage!");
	}
	
	@Test(dependsOnMethods= {"canNavigateToDropDown"})
	public void canSelectDropdownListItem() {
		//arrange
		Select dropDownList = new Select(driver.findElement(By.id("dropdown")));
		String expectedSelection = new String("Option 2");
		//act
		dropDownList.selectByValue("2");
		//assert
		Assert.assertEquals(dropDownList.getFirstSelectedOption().getText()
, expectedSelection, "Cannot select a dropdown list value");
	}
	
}