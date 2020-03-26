package com.ama.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ama.qa.base.TestBase;
import com.ama.qa.pages.ContactsPage;
import com.ama.qa.pages.HomePage;
import com.ama.qa.pages.LoginPage;
import com.ama.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname= "Sheet2";
public ContactsPageTest() {
	super();
}
@BeforeMethod
public void setUp() {
	intialization();
	loginpage=new LoginPage();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	testutil=new TestUtil();
	contactspage=new ContactsPage();
	testutil.SwitchToFrame();
	contactspage=homepage.ClickOnContactsLink();
	
}
@Test(priority=1)
public void verifyContactLabel() {
	Assert.assertTrue(contactspage.contactlabel());
	int i=9/0;
}
@DataProvider
public Object[][] getCRMTestData() {
	Object[][] data = TestUtil.getTestData(sheetname);
	return data;
}
@Test(priority=2, dataProvider="getCRMTestData")
public void createNewContactsTest(String Title, String Firstname, String Lastname, String Company) {
	homepage.clickOnNewContactsLink();
	contactspage.createNewContact(Title, Firstname, Lastname, Company);
}

@AfterMethod
public void tearDown() {
	driver.quit();
}

}
