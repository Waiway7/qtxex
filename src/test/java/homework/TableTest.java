package homework;

import org.testng.Assert;
import org.testng.annotations.Test;

import homework_page_objects.TablePageObject;
import test.SuperTest;

public class TableTest extends SuperTest {
	@Test
	public void gettingTableData(){
		String expectedAmount = "$100.00";
		String actualAmount = new TablePageObject(driver, baseUrl)
										.navigateTablePage()
										.getAmountBasedOffEmail("jdoe@hotmail.com");
		Assert.assertEquals(actualAmount, expectedAmount, "Wrong user");
	}
}