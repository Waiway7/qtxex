package homework;

import test.SuperTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import homework_page_objects.JSAlertPage;

public class AlertTest extends SuperTest{
	
	@Test
	public void handleJSAlert() {
		String expectedText = "You successfuly clicked an alert";
		String actualText = new JSAlertPage(driver, baseUrl)
								.navigateJSAlertPage()
								.clickButton("JS Alert")
								.acceptAlertMessage()
								.getActualText();
		
		Assert.assertEquals(actualText, expectedText, "Alert not clicked!");
	}
	
	@Test
	public void handleJSConfirm() {
		String expectedText = "You clicked: Ok";
		String actualText = new JSAlertPage(driver, baseUrl)
								.navigateJSAlertPage()
								.clickButton("JS Confirm")
								.acceptConfirmMessage()
								.getActualText();
		
		Assert.assertEquals(actualText, expectedText, "Alert not clicked!");
	}
	
	@Test
	public void handleJSPrompt() {
		String input = "test";
		String expectedText = "You entered: " + input;
		String actualText = new JSAlertPage(driver, baseUrl)
								.navigateJSAlertPage()
								.clickButton("JS Prompt")
								.sendPrompt(input)
								.getActualText();
		
		Assert.assertEquals(actualText, expectedText, "Alert not clicked!");
	}
}