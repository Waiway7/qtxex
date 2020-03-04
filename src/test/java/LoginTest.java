import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginTest extends SuperTest{
	
//	@Override
//	protected String url() {
//		return "http://the-internet.herokuapp.com/login";
//	}
	
	@Test
	public void canNavigateToLogin() {
		//arrange
		String expectedHeader = new String("Login Page");
		
		//act
		WebElement dropLogin = driver.findElement(
				By.xpath("//*[text()[contains(.,'Form Authentication')]]"));
		dropLogin.click();
		WebElement header = driver.findElement(By.tagName("h2"));
		
		//assert
		Assert.assertEquals(header.getText(), expectedHeader, "Wrong webpage!");
	}

	@Test(dependsOnMethods= {"canNavigateToLogin"})
	public void canLogIn() {
		//arrange
		String userName = new String("tomsmith");
		String password = new String("SuperSecretPassword!");
		
		//act
		WebElement userNameTextBox = driver.findElement(By.id("username"));
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.className("radius"));
		// driver.findElement(By.tagName("button"))
		
		userNameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		submitButton.submit();
//		
//		//assert
		WebElement verificationLoggedIn = driver.findElement(By.className("icon-signout"));
		String expectedText = new String("Logout");
////		boolean verification = verificationLoggedIn.getText() == expectedText;
		
		Assert.assertEquals(verificationLoggedIn.getText(), expectedText, "Cannot Login");
	}

}