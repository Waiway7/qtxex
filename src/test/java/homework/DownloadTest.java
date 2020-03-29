package homework;

import org.testng.annotations.Test;

import homework_page_objects.DownloadPageObject;
import file_reader.FileReaderWriter;
import test.SuperTest;

public class DownloadTest extends SuperTest {
	@Test
	public void downloadFile() throws Exception{
		new DownloadPageObject(driver, baseUrl).navigateTablePage().clickDownloadText();
	}
	
	@Test
	public void readFile() throws Exception{
		new FileReaderWriter().canReadFromFileUsingFileReader("/Users/ugp/Downloads/text.txt");
	}
	
}