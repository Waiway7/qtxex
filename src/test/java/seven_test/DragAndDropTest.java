package seven_test;

import java.io.IOException;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.SuperTest;
import seven_page_objects.DragDropPageObject;


public class DragAndDropTest extends SuperTest {
	    
	@Test
	public void checkDragAndDropTest() throws IOException {
		DragDropPageObject dragDropObject = new DragDropPageObject(driver, baseUrl)
												.openDragDropPage();
		Point orgPosBoxA = dragDropObject.getBoxALocation();
		Point newPosBoxA = dragDropObject.executeScript().getBoxALocation();
		
		Assert.assertEquals(orgPosBoxA, newPosBoxA, "Drag and drop did not work!");
	}
	
}