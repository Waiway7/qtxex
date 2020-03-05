import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends SuperPageObject {
	
	public LoginPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public LoginPageObject openLoginPage() {
		String url = "/login";
		navigate(url);
		return this;
	}
	
	public SecurePageObject login(String username, String password) {
		WebElement userNameTextBox = driver.findElement(By.id("username"));
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.className("radius"));
		
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		submitButton.submit();
		
		return new SecurePageObject(driver);
	}
	
}
