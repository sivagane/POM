package com.ama.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ama.qa.base.TestBase;

public class LoginPage extends TestBase {


	@FindBy(name="username")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement PassWord;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	public LoginPage() {
	PageFactory.initElements(driver, this);
	}
	public HomePage login(String un, String pwd) {
		UserName.sendKeys(un);
		PassWord.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
	}
	
}
