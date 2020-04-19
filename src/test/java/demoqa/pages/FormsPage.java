package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import demoqa.dataBuilders.PersonalInformation;

import demoqa.framework.PageBase;

public class FormsPage extends PageBase {
	
	@FindBy(how=How.NAME, using="firstname")
	public WebElement firstNameTextbox;
	
	@FindBy(how=How.ID, using="lastname")
	public WebElement lastNameTextbox;
	
	@FindBy(how=How.ID, using="sex-0")
	WebElement maleRadio;
	
	@FindBy(how=How.ID, using="sex-1")
	WebElement femaleRadio;
	
	public FormsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public FormsPage navigate() {
		super.navigate("/automation-practice-form");
		return this;
	}
	
	public String getGender() {
		if (maleRadio.isSelected()) {
			return "Male";
		}
		else if (femaleRadio.isSelected()) {
			return "Female";
		}
		
		return null;
	}
	
	public FormsPage enterFormDetails(String firstName, String lastName, String gender) {
		if(!firstName.equals(null)) {
			firstNameTextbox.sendKeys(firstName);
		}

		if(!lastNameTextbox.equals(null)) {
			lastNameTextbox.sendKeys(lastName);
		}

		if(!gender.equals(null)) {

			if(gender.equals("Male")) {
				maleRadio.click();
			}
			if(gender.equals("Female")) {
				femaleRadio.click();
			}
		}

		return this;
	}
	
	public FormsPage enterFormDetails(demoqa.dataBuilders.PersonalInformation data) {
		return enterFormDetails(data.getFirstName(), data.getLastName(), data.getGender());
	}
	
	public PersonalInformation getFormFieldData() {
		PersonalInformation personalInformation = new PersonalInformation();
		personalInformation.setFirstName(firstNameTextbox.getAttribute("value")); 
		personalInformation.setLastName(lastNameTextbox.getAttribute("value")); 
		personalInformation.setGender(getGender());
		
		return personalInformation;
	}
	
}