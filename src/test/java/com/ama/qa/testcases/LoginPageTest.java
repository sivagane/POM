package com.ama.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ama.qa.base.TestBase;
import com.ama.qa.pages.HomePage;
import com.ama.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
@BeforeMethod
public void setUp() {
	intialization();
	loginpage=new LoginPage();
}
	@Test
	public void Validatelogin() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
