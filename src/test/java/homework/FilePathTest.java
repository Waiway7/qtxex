package homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.SuperTest;
import homework_page_objects.JqueryMenuPage;

public class FilePathTest extends SuperTest{
	
	@Test
	public void clickFileDownload() {
		String[] menuText =  new String[] {"Enabled", "Downloads", "Excel"};
		String dir = "/Users/ugp/Downloads";
		String fileName = "menu.xls";
		
		boolean isFileDownloaded = new JqueryMenuPage(driver, baseUrl)
				.navigateJqueryMenuPage()
				.clickItemByMenuPath(menuText)
				.isFileDownloaded(dir, fileName);
		
		Assert.assertTrue(isFileDownloaded, "File was not downloaded");
	}
}