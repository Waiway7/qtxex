package test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import page_objects.LoginPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends SuperTest{

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
