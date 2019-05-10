package com.nc.qa.testcases;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.Registerpage;
import com.nc.qa.pages.SignInpage;
import com.nc.qa.util.TestUtil;

public class SignIntest extends TestBase {
SignInpage sp;
TestUtil tu;
	String sheetName="Signin";
	Logger log = Logger.getLogger(SignIntest.class);
	
	public SignIntest() throws Exception {
		super();
		
	}
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		log.info("****************************** Starting test cases execution  *****************************************");
		//initialization("browser");
		beforeclass("browser");
		log.info("********chrome browser is opened************");
	}
	@DataProvider
	public Object[][] getsigninTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getsigninTestData",priority=1)
	public void signintest(String Username,String Password) throws Exception
	
	{
		sp=PageFactory.initElements(driver,SignInpage.class);
	//sp.signin(prop.getProperty("username"),prop.getProperty("password"));
		sp.signin(Username, Password);
	}
	/*@Test(priority=2)
	public void signinpagetittletest()
	{
		String title=sp.validateLoginPageTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(title, "Lippincott NursingCenter");
	}*/

@AfterMethod
public void close()
{
	driver.close();
}
}