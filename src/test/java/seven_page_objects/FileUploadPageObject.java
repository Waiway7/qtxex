package seven_page_objects;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_objects.SuperPageObject;

public class FileUploadPageObject extends SuperPageObject {
	public FileUploadPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public FileUploadPageObject openUploadPage() {
		String url = "/upload";
		navigate(url);
		return this;
	}
	
	public File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}
	
	public String getFilePath() {
		return getFile("QualityAssuranceTest.txt").getAbsolutePath();
	}
	
	public WebElement getInputUpload() {
		return driver.findElement(By.id("file-upload"));
	}
	
	public FileUploadPageObject uploadFile() {
		getInputUpload().sendKeys(getFilePath());
		return this;
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(By.id("file-submit"));
	}
	
	public SecureUploadPageObject clickSubmit() {
		getSubmitButton().click();
		return new SecureUploadPageObject(driver, baseUrl);
	}
}