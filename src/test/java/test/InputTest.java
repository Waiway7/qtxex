package test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import page_objects.InputPageObject;

public class InputTest extends SuperTest{
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