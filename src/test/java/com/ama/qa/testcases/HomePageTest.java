package com.ama.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ama.qa.base.TestBase;
import com.ama.qa.pages.ContactsPage;
import com.ama.qa.pages.HomePage;
import com.ama.qa.pages.LoginPage;
import com.ama.qa.util.TestUtil;

public class HomePageTest extends TestBase {
LoginPage loginpage;
HomePage homepage;
TestUtil testutil;
ContactsPage contactspage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	   
	}
	    @Test(priority=1)
	    public void verifyHomePageTitleTest() {
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "The Title is not matched");
	}
		@Test(priority=2)
		public void verifyUserTest() {
			 testutil.SwitchToFrame();
			Assert.assertTrue( homepage.verifyUser());
		}
		@Test(priority=3)
		public void verifyContactsLinkTest() {
			testutil.SwitchToFrame();
			contactspage=homepage.ClickOnContactsLink();
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
