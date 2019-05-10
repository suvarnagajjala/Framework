package com.nc.qa.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.Journalspage;
import com.nc.qa.pages.Registerpage;
import com.nc.qa.pages.SignInpage;

public class Journalstest extends TestBase {
	Journalspage jp;
	SignInpage sp;

	public Journalstest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/*
	 * @Parameters("browser") //@BeforeClass public void crossbrowser(String
	 * browser) { if(browser.equals("chrome")) {
	 * System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	 * driver=new ChromeDriver(); } else if(browser.equals("firefox")) {
	 * System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
	 * driver=new FirefoxDriver(); } String URL=prop.getProperty("url");
	 * driver.get(URL); }
	 */
	
	  @BeforeMethod 
	  public void setup() throws MalformedURLException 
	  { beforeclass("browser");
	  }
	 
		
	@Test(priority=1)
		public void journals() throws Exception
		{
			jp=PageFactory.initElements(driver,Journalspage.class);
			sp=PageFactory.initElements(driver,SignInpage.class);
			sp.clickonsign();
		sp.signin(prop.getProperty("username"),prop.getProperty("password"));
			jp=PageFactory.initElements(driver,Journalspage.class);
			jp.journals();
}
		@AfterMethod
		public void close()
		{
			driver.close();
		}

}
