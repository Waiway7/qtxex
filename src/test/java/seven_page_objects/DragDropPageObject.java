package seven_page_objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_objects.SuperPageObject;

public class DragDropPageObject extends SuperPageObject {
	
	public DragDropPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public DragDropPageObject openDragDropPage() {
		String url = "/drag_and_drop";
		navigate(url);
		return this;
	}
	
	public File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}
	
	public String getFilePathJquery() {
		return getFile("JqueryLoaderHelper.js").getAbsolutePath();
	}
	
	public String getFilePathJS() {
		return getFile("DragAndDropHelper.js").getAbsolutePath();
	}
	
	public WebElement getBoxA() {
		return driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
	}
	
	public WebElement getBoxB() {
		return driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
	}
	
	public DragDropPageObject executeScript() throws IOException {
		String jQueryLoader = readFile(getFilePathJquery());
		String dragAndDrop = readFile(getFilePathJS());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeAsyncScript(jQueryLoader, "http://code.jquery.com/jquery-1.11.2.min.js");
	    js.executeScript(dragAndDrop + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});");
		return this;
	}
	
	public Point getBoxALocation() {
		return getBoxA().getLocation();
	}
	
	public Point getBoxBLocation() {
		return getBoxB().getLocation();
	}
	
	private static String readFile(String file) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        }
        finally {
            stream.close();
        }        
    }
}