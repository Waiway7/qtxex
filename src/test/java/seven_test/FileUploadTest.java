package seven_test;

import test.SuperTest;
import seven_page_objects.FileUploadPageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends SuperTest{
	
	@Test
	public void checkFileUpload() {
		String expectedText = "QualityAssuranceTest.txt";
		String actualText = new FileUploadPageObject(driver, baseUrl)
								.openUploadPage()
								.uploadFile()
								.clickSubmit()
								.getUploadedFileName();
		Assert.assertEquals(actualText, expectedText, "File Uploaded");
		
	}
	
}