
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
	
//		//assert
		String expectedText = new String("Logout");		
		Assert.assertEquals(actualGreenBoxText, expectedText, "Cannot Login");
	}
}

//@Override
//protected String url() {
//	return "http://the-internet.herokuapp.com/login";
//}

//@Test
//public void canNavigateToLogin() {
//	//arrange
//	String expectedHeader = new String("Login Page");
//	
//	//act
//	WebElement dropLogin = driver.findElement(
//			By.xpath("//*[text()[contains(.,'Form Authentication')]]"));
//	dropLogin.click();
//	WebElement header = driver.findElement(By.tagName("h2"));
//	
//	//assert
//	Assert.assertEquals(header.getText(), expectedHeader, "Wrong webpage!");
//}