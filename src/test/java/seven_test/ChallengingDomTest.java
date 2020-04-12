package seven_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.SuperTest;

import seven_page_objects.ChallengingDomPageObject;

public class ChallengingDomTest extends SuperTest {
	
	@Test
	public void checkBrokenImages() {
		String actualNumber = new ChallengingDomPageObject(driver, baseUrl)
								.openDomPageObject()
								.getNumber();
		System.out.println(actualNumber);
		Assert.assertNotNull(actualNumber, "Invalid Script");
	}
}