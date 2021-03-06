package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import page_objects.CheckPageObject;
import page_objects.DropDownPageObject;
import page_objects.InputPageObject;
import page_objects.LoginPageObject;
import page_objects.SliderPageObject;

public class TheInternet extends SuperTest {
	public class LoginTest {

		@Test
		public void canLogIn() {
			//arrange
			String username = new String("tomsmith");
			String password = new String("SuperSecretPassword!");
			
			//act
			String actualGreenBoxText = new LoginPageObject(driver, baseUrl)
					.openLoginPage()
					.login(username, password)
					.getLoginConfirmationMessage();
		
			//assert
			String expectedText = new String("Logout");		
			Assert.assertEquals(actualGreenBoxText, expectedText, "Cannot Login");
		}
	}
	
	public class DropDownTest {
		
		@Test
		public void canSelectDropdownListItem() {
			//arrange
			String expectedSelection = new String("Option 2");
			//act
			String actualSelection = new DropDownPageObject(driver, baseUrl)
					.openDropDownPage()
					.setDropDownList(expectedSelection)
					.getDropDownListValue();
			Assert.assertEquals(actualSelection, expectedSelection, "Cannot select a dropdown list value");		}
		
	}
	
	public class CheckTest {
	
		@Test
		public void canCheckAll() {
			List <WebElement> checkBoxes = new CheckPageObject(driver, baseUrl)
												.openCheckPage()
												.canCheckBoxes()
												.getCheckBoxes();
			
			
			for (int i = 0; i < checkBoxes.size(); i++) {
				String checkBoxNum = String.format("%s", i+1); 
				String errorMessage = "Failed to select Checkbox " + checkBoxNum;;
				Assert.assertTrue(checkBoxes.get(i).isSelected(), errorMessage);
			}
		}
	}
	
	public class SliderTest {
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
	
	public class InputTest{
		@Test(dataProvider = "numberData")
		public void canTypeInInputField(int number) {
			String inputValue = new InputPageObject(driver, baseUrl)
								.openInputPage()
								.setInputValue(number)
								.waitForValue()
								.getInputValue();
		
		String expectedValue = String.valueOf(number);
		
		Assert.assertEquals(inputValue, expectedValue);
	}
	
		@DataProvider(name = "numberData")
		public Object[] getNumberData() {

			return new Object[] {2,3,5,8,13}; 
		}
	}
}