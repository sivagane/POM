package com.ama.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ama.qa.util.WebEventListener;


public class TestBase {
public static Properties prop;
public static WebDriver driver;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
	
   public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\jegan\\eclipse-workspace\\POMNaAuLa\\src\\main\\java\\com\\ama\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void intialization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jegan\\eclipse-workspace\\POMNaAuLa\\div\\chromedriver.exe");
			driver=new ChromeDriver();
			}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
    	e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
}
