package com.ama.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ama.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement User;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage ClickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyUser() {
		return User.isDisplayed();
	}
	public void clickOnNewContactsLink() {
		Actions action=new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newContactsLink.click();
	}
	
}
