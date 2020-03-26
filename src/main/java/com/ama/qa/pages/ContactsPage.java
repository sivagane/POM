package com.ama.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ama.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//input[@type='checkbox' and @value='52739423']")
	WebElement CheckBoxBtn;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement Company;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//input[@type='submit'and@value='Save']")
	WebElement SaveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactlabel() {
		return ContactsLabel.isDisplayed();
	}
	
	public void createNewContact(String title, String firstname, String lastname, String company ) {
		Select s=new Select(driver.findElement(By.xpath("//select[@name='title']")));
		s.selectByVisibleText(title);
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		Company.sendKeys(company);
		SaveBtn.click();
		
	}

}
