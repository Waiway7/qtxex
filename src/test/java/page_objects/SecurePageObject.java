package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePageObject{
	private WebDriver driver;
	
	@FindBy(className="icon-signout")
	private WebElement greenBox;
	
	public SecurePageObject(WebDriver driverInstance) {
		driver = driverInstance;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginConfirmationMessage() {
		return greenBox.getText();
	}
	
}