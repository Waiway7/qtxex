package seven_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import seven_page_objects.DigestAuthPageObject;
import test.SuperTest;

public class DigestAuthTest extends SuperTest {
	
	@Test
	public void verifyCredentials() {
		String expectedString = "Congratulations! You must have the proper credentials.";
		String actualString = new DigestAuthPageObject(driver)
									.openDigestPage()
									.getText();
		Assert.assertEquals(actualString, expectedString, "Wrong credentials!");
	}
}