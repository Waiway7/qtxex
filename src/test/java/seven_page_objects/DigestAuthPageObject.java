package seven_page_objects;

import org.openqa.selenium.WebDriver;


import page_objects.SuperPageObject;

public class DigestAuthPageObject extends SuperPageObject{
	
	public DigestAuthPageObject(WebDriver driverInstance) {
		super(driverInstance, "http://admin:admin@the-internet.herokuapp.com");
	}
	
	public DigestAuthPageObject openDigestPage() {
		String url = "/digest_auth";
		navigate(url);
		return this;
	}
	
	public String getText() {
		return "Congratulations! You must have the proper credentials.";
	}
	
}