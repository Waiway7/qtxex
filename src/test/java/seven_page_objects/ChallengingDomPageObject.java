package seven_page_objects;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_objects.SuperPageObject;

public class ChallengingDomPageObject extends SuperPageObject {
	public ChallengingDomPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	
	public ChallengingDomPageObject openDomPageObject() {
		String url = "/challenging_dom";
		navigate(url);
		return this;
	}
	
	public List<WebElement> getScript() {
		return driver.findElements(By.tagName("script"));
	}
	
	public WebElement getFoo() {
		return driver.findElement(By.className("button"));
	}
	
	public WebElement getBaz() {
		return driver.findElement(By.cssSelector("a[class='button alert']"));
	}
	
	public WebElement getBoxFoo() {
		return driver.findElement(By.cssSelector("a[class='button success']"));
	}
	
	public ChallengingDomPageObject clickFoo() {
		getFoo().click();
		return this;
	}
	
	public ChallengingDomPageObject clickBaz() {
		getBaz().click();
		return this;
	}
	
	public ChallengingDomPageObject clickBoxFoo() {
		getBoxFoo().click();
		return this;
	}
	
	public String getNumber() {
		getScript();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String query = "return document.getElementsByTagName(\"script\")[arguments[0]].innerHTML;";     
		Pattern p = Pattern.compile("canvas.strokeText\\('Answer: \\d+'");
		Pattern p2 = Pattern.compile("\\d+");
		
		String number = IntStream.range(0, getScript().size())
		        .mapToObj(i -> (String)js.executeScript(query, i))
		        .map(string -> p.matcher(string))
        		.filter(m -> m.find())
		        .map(m -> p2.matcher(m.group()))
		        .filter(m -> m.find())
		        .map(m -> m.group())
		        .findFirst()
		        .orElse(null);
		return number;
	}
	
}